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
    private View fic;
    private TextView fng;
    private final d fzA;
    private TextView fzB;
    private TextView fzC;
    private View fzD;
    private com.baidu.tieba.NEGFeedBack.e fzE;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fzA = new d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.frs_multi_delete_menu_layout, this);
        this.fng = (TextView) findViewById(d.g.multi_del_cancel_btn);
        this.fng.setText(d.j.cancel);
        this.fzB = (TextView) findViewById(d.g.multi_del_btn);
        this.fzB.setText(d.j.delete);
        this.fzC = (TextView) findViewById(d.g.multi_del_forbidden_btn);
        this.fzC.setText(d.j.delete_and_forbidden_one_day);
        this.fic = findViewById(d.g.divider_top_line);
        this.fzD = findViewById(d.g.divider);
        this.fng.setOnClickListener(this);
        this.fzB.setOnClickListener(this);
        this.fzC.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(d.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fzB.setText(string);
    }

    public void onChangeSkinType() {
        al.l(this, d.C0236d.cp_bg_line_d);
        al.j(this.fng, d.C0236d.cp_cont_b);
        al.k(this.fng, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.fzC, d.C0236d.cp_cont_b);
        al.k(this.fzC, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.fzB, d.C0236d.cp_cont_h);
        al.k(this.fzB, d.f.bg_bottom_up_list_dialog_item);
        al.l(this.fic, d.C0236d.cp_bg_line_c);
        al.l(this.fzD, d.C0236d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fzA.registerListener();
        if (view == this.fng) {
            com.baidu.tieba.frs.a.bbF().reset();
        } else if (view == this.fzB) {
            if (!v.T(com.baidu.tieba.frs.a.bbF().bbH())) {
                TiebaStatic.log(new am("c13122").T("obj_type", 1));
                setData(1);
                vR("2");
            }
        } else if (view == this.fzC && !v.T(com.baidu.tieba.frs.a.bbF().bbH())) {
            TiebaStatic.log(new am("c13122").T("obj_type", 2));
            setData(2);
            vR("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void vR(String str) {
        if (this.pageContext != null) {
            if (this.fzE == null) {
                this.fzE = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fzE.qj(str);
        }
    }

    public void bdS() {
        if (this.fzE != null) {
            this.fzE.auZ();
        }
    }

    public void auU() {
        if (this.fzE != null) {
            this.fzE.auU();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fzE == null) {
                this.fzE = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
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
            this.fzE.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            this.fzE.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fzA != null) {
            this.fzA.a((d.a) null);
            this.fzA.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fzA != null) {
            this.fzA.a(aVar);
        }
    }
}
