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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.e;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes6.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View dUp;
    private TextView dZD;
    private final com.baidu.tieba.NEGFeedBack.d ekG;
    private TextView ekH;
    private TextView ekI;
    private View ekJ;
    private com.baidu.tieba.NEGFeedBack.e ekK;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.ekG = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(e.h.frs_multi_delete_menu_layout, this);
        this.dZD = (TextView) findViewById(e.g.multi_del_cancel_btn);
        this.dZD.setText(e.j.cancel);
        this.ekH = (TextView) findViewById(e.g.multi_del_btn);
        this.ekH.setText(e.j.delete);
        this.ekI = (TextView) findViewById(e.g.multi_del_forbidden_btn);
        this.ekI.setText(e.j.delete_and_forbidden_one_day);
        this.dUp = findViewById(e.g.divider_top_line);
        this.ekJ = findViewById(e.g.divider);
        this.dZD.setOnClickListener(this);
        this.ekH.setOnClickListener(this);
        this.ekI.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(e.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ekH.setText(string);
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.dZD, e.d.cp_cont_b);
        al.i(this.dZD, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.ekI, e.d.cp_cont_b);
        al.i(this.ekI, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.ekH, e.d.cp_cont_h);
        al.i(this.ekH, e.f.bg_bottom_up_list_dialog_item);
        al.j(this.dUp, e.d.cp_bg_line_c);
        al.j(this.ekJ, e.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZD) {
            com.baidu.tieba.frs.a.aBg().reset();
        } else if (view == this.ekH) {
            if (!v.I(com.baidu.tieba.frs.a.aBg().aBi())) {
                TiebaStatic.log(new am("c13122").y("obj_type", 1));
                setData(1);
                pi("2");
            }
        } else if (view == this.ekI && !v.I(com.baidu.tieba.frs.a.aBg().aBi())) {
            TiebaStatic.log(new am("c13122").y("obj_type", 2));
            setData(2);
            pi("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void pi(String str) {
        if (this.pageContext != null) {
            if (this.ekK == null) {
                this.ekK = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.ekK.jy(str);
        }
    }

    public void aDl() {
        if (this.ekK != null) {
            this.ekK.Va();
        }
    }

    public void UX() {
        if (this.ekK != null) {
            this.ekK.UX();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.ekK == null) {
                this.ekK = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData aBj = com.baidu.tieba.frs.a.aBg().aBj();
            if (aBj != null && aBj.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aBj.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> aBi = com.baidu.tieba.frs.a.aBg().aBi();
            for (int i3 = 0; i3 < aBi.size(); i3++) {
                jSONArray.put(aBi.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cE(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.aBg().getForumId());
            this.ekK.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            this.ekK.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.ekG != null) {
            this.ekG.a((d.a) null);
            this.ekG.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.ekG != null) {
            this.ekG.a(aVar);
        }
    }
}
