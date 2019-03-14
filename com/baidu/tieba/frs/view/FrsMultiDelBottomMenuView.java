package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.d;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View fib;
    private TextView fnf;
    private TextView fzA;
    private TextView fzB;
    private View fzC;
    private com.baidu.tieba.NEGFeedBack.e fzD;
    private final com.baidu.tieba.NEGFeedBack.d fzz;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fzz = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.frs_multi_delete_menu_layout, this);
        this.fnf = (TextView) findViewById(d.g.multi_del_cancel_btn);
        this.fnf.setText(d.j.cancel);
        this.fzA = (TextView) findViewById(d.g.multi_del_btn);
        this.fzA.setText(d.j.delete);
        this.fzB = (TextView) findViewById(d.g.multi_del_forbidden_btn);
        this.fzB.setText(d.j.delete_and_forbidden_one_day);
        this.fib = findViewById(d.g.divider_top_line);
        this.fzC = findViewById(d.g.divider);
        this.fnf.setOnClickListener(this);
        this.fzA.setOnClickListener(this);
        this.fzB.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(d.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fzA.setText(string);
    }

    public void onChangeSkinType() {
        al.l(this, d.C0277d.cp_bg_line_d);
        al.j(this.fnf, d.C0277d.cp_cont_b);
        al.k(this.fnf, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.fzB, d.C0277d.cp_cont_b);
        al.k(this.fzB, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.fzA, d.C0277d.cp_cont_h);
        al.k(this.fzA, d.f.bg_bottom_up_list_dialog_item);
        al.l(this.fib, d.C0277d.cp_bg_line_c);
        al.l(this.fzC, d.C0277d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fzz.registerListener();
        if (view == this.fnf) {
            com.baidu.tieba.frs.a.bbF().reset();
        } else if (view == this.fzA) {
            if (!v.T(com.baidu.tieba.frs.a.bbF().bbH())) {
                TiebaStatic.log(new am("c13122").T("obj_type", 1));
                setData(1);
                vQ("2");
            }
        } else if (view == this.fzB && !v.T(com.baidu.tieba.frs.a.bbF().bbH())) {
            TiebaStatic.log(new am("c13122").T("obj_type", 2));
            setData(2);
            vQ("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void vQ(String str) {
        if (this.pageContext != null) {
            if (this.fzD == null) {
                this.fzD = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fzD.qi(str);
        }
    }

    public void bdS() {
        if (this.fzD != null) {
            this.fzD.auZ();
        }
    }

    public void auU() {
        if (this.fzD != null) {
            this.fzD.auU();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fzD == null) {
                this.fzD = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bbI = com.baidu.tieba.frs.a.bbF().bbI();
            if (bbI != null && bbI.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbI.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> bbH = com.baidu.tieba.frs.a.bbF().bbH();
            for (int i3 = 0; i3 < bbH.size(); i3++) {
                jSONArray.put(bbH.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gg(i);
            ajVar.w(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.bbF().getForumId());
            this.fzD.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            this.fzD.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fzz != null) {
            this.fzz.a((d.a) null);
            this.fzz.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fzz != null) {
            this.fzz.a(aVar);
        }
    }
}
