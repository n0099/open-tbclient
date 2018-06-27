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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.d;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private final com.baidu.tieba.NEGFeedBack.d dHv;
    private TextView dHw;
    private TextView dHx;
    private View dHy;
    private com.baidu.tieba.NEGFeedBack.e dHz;
    private View drT;
    private TextView dxi;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.dHv = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.i.frs_multi_delete_menu_layout, this);
        this.dxi = (TextView) findViewById(d.g.multi_del_cancel_btn);
        this.dxi.setText(d.k.cancel);
        this.dHw = (TextView) findViewById(d.g.multi_del_btn);
        this.dHw.setText(d.k.delete);
        this.dHx = (TextView) findViewById(d.g.multi_del_forbidden_btn);
        this.dHx.setText(d.k.delete_and_forbidden_one_day);
        this.drT = findViewById(d.g.divider_top_line);
        this.dHy = findViewById(d.g.divider);
        this.dxi.setOnClickListener(this);
        this.dHw.setOnClickListener(this);
        this.dHx.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(d.k.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.dHw.setText(string);
    }

    public void onChangeSkinType() {
        am.j(this, d.C0142d.cp_bg_line_d);
        am.h(this.dxi, d.C0142d.cp_cont_b);
        am.i(this.dxi, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.dHx, d.C0142d.cp_cont_b);
        am.i(this.dHx, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.dHw, d.C0142d.cp_cont_h);
        am.i(this.dHw, d.f.bg_bottom_up_list_dialog_item);
        am.j(this.drT, d.C0142d.cp_bg_line_c);
        am.j(this.dHy, d.C0142d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dxi) {
            com.baidu.tieba.frs.a.asZ().reset();
        } else if (view == this.dHw) {
            if (!w.A(com.baidu.tieba.frs.a.asZ().atb())) {
                TiebaStatic.log(new an("c13122").r("obj_type", 1));
                setData(1);
                nf("2");
            }
        } else if (view == this.dHx && !w.A(com.baidu.tieba.frs.a.asZ().atb())) {
            TiebaStatic.log(new an("c13122").r("obj_type", 2));
            setData(2);
            nf("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void nf(String str) {
        if (this.pageContext != null) {
            if (this.dHz == null) {
                this.dHz = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.dHz.ib(str);
        }
    }

    public void auZ() {
        if (this.dHz != null) {
            this.dHz.Ps();
        }
    }

    public void Pp() {
        if (this.dHz != null) {
            this.dHz.Pp();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.dHz == null) {
                this.dHz = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData Cm = com.baidu.tieba.frs.a.asZ().Cm();
            if (Cm != null && Cm.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cm.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bc> atb = com.baidu.tieba.frs.a.asZ().atb();
            for (int i3 = 0; i3 < atb.size(); i3++) {
                jSONArray.put(atb.get(i3).getTid());
            }
            ai aiVar = new ai();
            aiVar.a(sparseArray);
            aiVar.bF(i);
            aiVar.c(jSONArray);
            aiVar.setFid(com.baidu.tieba.frs.a.asZ().getForumId());
            this.dHz.setDefaultReasonArray(new String[]{getContext().getString(d.k.delete_thread_reason_1), getContext().getString(d.k.delete_thread_reason_2), getContext().getString(d.k.delete_thread_reason_3), getContext().getString(d.k.delete_thread_reason_4), getContext().getString(d.k.delete_thread_reason_5)});
            this.dHz.setData(aiVar);
        }
    }

    public void onDestroy() {
        if (this.dHv != null) {
            this.dHv.a((d.a) null);
            this.dHv.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.dHv != null) {
            this.dHv.a(aVar);
        }
    }
}
