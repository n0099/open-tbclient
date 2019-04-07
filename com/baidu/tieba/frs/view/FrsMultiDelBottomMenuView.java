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
    private View fhN;
    private TextView fmR;
    private final com.baidu.tieba.NEGFeedBack.d fzn;
    private TextView fzo;
    private TextView fzp;
    private View fzq;
    private com.baidu.tieba.NEGFeedBack.e fzr;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fzn = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.frs_multi_delete_menu_layout, this);
        this.fmR = (TextView) findViewById(d.g.multi_del_cancel_btn);
        this.fmR.setText(d.j.cancel);
        this.fzo = (TextView) findViewById(d.g.multi_del_btn);
        this.fzo.setText(d.j.delete);
        this.fzp = (TextView) findViewById(d.g.multi_del_forbidden_btn);
        this.fzp.setText(d.j.delete_and_forbidden_one_day);
        this.fhN = findViewById(d.g.divider_top_line);
        this.fzq = findViewById(d.g.divider);
        this.fmR.setOnClickListener(this);
        this.fzo.setOnClickListener(this);
        this.fzp.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(d.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fzo.setText(string);
    }

    public void onChangeSkinType() {
        al.l(this, d.C0277d.cp_bg_line_d);
        al.j(this.fmR, d.C0277d.cp_cont_b);
        al.k(this.fmR, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.fzp, d.C0277d.cp_cont_b);
        al.k(this.fzp, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.fzo, d.C0277d.cp_cont_h);
        al.k(this.fzo, d.f.bg_bottom_up_list_dialog_item);
        al.l(this.fhN, d.C0277d.cp_bg_line_c);
        al.l(this.fzq, d.C0277d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fzn.registerListener();
        if (view == this.fmR) {
            com.baidu.tieba.frs.a.bbD().reset();
        } else if (view == this.fzo) {
            if (!v.T(com.baidu.tieba.frs.a.bbD().bbF())) {
                TiebaStatic.log(new am("c13122").T("obj_type", 1));
                setData(1);
                vP("2");
            }
        } else if (view == this.fzp && !v.T(com.baidu.tieba.frs.a.bbD().bbF())) {
            TiebaStatic.log(new am("c13122").T("obj_type", 2));
            setData(2);
            vP("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void vP(String str) {
        if (this.pageContext != null) {
            if (this.fzr == null) {
                this.fzr = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fzr.qj(str);
        }
    }

    public void bdQ() {
        if (this.fzr != null) {
            this.fzr.auW();
        }
    }

    public void auR() {
        if (this.fzr != null) {
            this.fzr.auR();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fzr == null) {
                this.fzr = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bbG = com.baidu.tieba.frs.a.bbD().bbG();
            if (bbG != null && bbG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> bbF = com.baidu.tieba.frs.a.bbD().bbF();
            for (int i3 = 0; i3 < bbF.size(); i3++) {
                jSONArray.put(bbF.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gf(i);
            ajVar.w(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.bbD().getForumId());
            this.fzr.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            this.fzr.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fzn != null) {
            this.fzn.a((d.a) null);
            this.fzn.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fzn != null) {
            this.fzn.a(aVar);
        }
    }
}
