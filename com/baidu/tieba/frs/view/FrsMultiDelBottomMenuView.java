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
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View dBk;
    private TextView dGB;
    private final com.baidu.tieba.NEGFeedBack.d dRq;
    private TextView dRr;
    private TextView dRs;
    private View dRt;
    private com.baidu.tieba.NEGFeedBack.e dRu;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.dRq = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(e.h.frs_multi_delete_menu_layout, this);
        this.dGB = (TextView) findViewById(e.g.multi_del_cancel_btn);
        this.dGB.setText(e.j.cancel);
        this.dRr = (TextView) findViewById(e.g.multi_del_btn);
        this.dRr.setText(e.j.delete);
        this.dRs = (TextView) findViewById(e.g.multi_del_forbidden_btn);
        this.dRs.setText(e.j.delete_and_forbidden_one_day);
        this.dBk = findViewById(e.g.divider_top_line);
        this.dRt = findViewById(e.g.divider);
        this.dGB.setOnClickListener(this);
        this.dRr.setOnClickListener(this);
        this.dRs.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(e.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.dRr.setText(string);
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.dGB, e.d.cp_cont_b);
        al.i(this.dGB, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.dRs, e.d.cp_cont_b);
        al.i(this.dRs, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.dRr, e.d.cp_cont_h);
        al.i(this.dRr, e.f.bg_bottom_up_list_dialog_item);
        al.j(this.dBk, e.d.cp_bg_line_c);
        al.j(this.dRt, e.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dGB) {
            com.baidu.tieba.frs.a.avq().reset();
        } else if (view == this.dRr) {
            if (!v.z(com.baidu.tieba.frs.a.avq().avs())) {
                TiebaStatic.log(new am("c13122").w("obj_type", 1));
                setData(1);
                nL("2");
            }
        } else if (view == this.dRs && !v.z(com.baidu.tieba.frs.a.avq().avs())) {
            TiebaStatic.log(new am("c13122").w("obj_type", 2));
            setData(2);
            nL("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void nL(String str) {
        if (this.pageContext != null) {
            if (this.dRu == null) {
                this.dRu = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.dRu.iA(str);
        }
    }

    public void axw() {
        if (this.dRu != null) {
            this.dRu.Rr();
        }
    }

    public void Ro() {
        if (this.dRu != null) {
            this.dRu.Ro();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.dRu == null) {
                this.dRu = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData avt = com.baidu.tieba.frs.a.avq().avt();
            if (avt != null && avt.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = avt.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> avs = com.baidu.tieba.frs.a.avq().avs();
            for (int i3 = 0; i3 < avs.size(); i3++) {
                jSONArray.put(avs.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.bQ(i);
            ahVar.g(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.avq().getForumId());
            this.dRu.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            this.dRu.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.dRq != null) {
            this.dRq.a((d.a) null);
            this.dRq.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.dRq != null) {
            this.dRq.a(aVar);
        }
    }
}
