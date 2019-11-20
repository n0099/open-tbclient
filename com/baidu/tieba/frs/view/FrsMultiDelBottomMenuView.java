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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View fEh;
    private TextView fJr;
    private final com.baidu.tieba.NEGFeedBack.d fWs;
    private TextView fWt;
    private TextView fWu;
    private View fWv;
    private com.baidu.tieba.NEGFeedBack.e fWw;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fWs = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fJr = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fJr.setText(R.string.cancel);
        this.fWt = (TextView) findViewById(R.id.multi_del_btn);
        this.fWt.setText(R.string.delete);
        this.fWu = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fWu.setText(R.string.delete_and_forbidden_one_day);
        this.fEh = findViewById(R.id.divider_top_line);
        this.fWv = findViewById(R.id.divider);
        this.fJr.setOnClickListener(this);
        this.fWt.setOnClickListener(this);
        this.fWu.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fWt.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fJr, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.fJr, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.fWu, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.fWu, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.fWt, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.fWt, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.fEh, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fWv, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fWs.registerListener();
        if (view == this.fJr) {
            com.baidu.tieba.frs.a.biU().reset();
        } else if (view == this.fWt) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.biU().biW())) {
                TiebaStatic.log(new an("c13122").O("obj_type", 1));
                setData(1);
                wD("2");
            }
        } else if (view == this.fWu && !v.isEmpty(com.baidu.tieba.frs.a.biU().biW())) {
            TiebaStatic.log(new an("c13122").O("obj_type", 2));
            setData(2);
            wD("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void wD(String str) {
        if (this.pageContext != null) {
            if (this.fWw == null) {
                this.fWw = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fWw.qE(str);
        }
    }

    public void blj() {
        if (this.fWw != null) {
            this.fWw.aBQ();
        }
    }

    public void aBM() {
        if (this.fWw != null) {
            this.fWw.aBM();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fWw == null) {
                this.fWw = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData biX = com.baidu.tieba.frs.a.biU().biX();
            if (biX != null && biX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biX.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> biW = com.baidu.tieba.frs.a.biU().biW();
            for (int i3 = 0; i3 < biW.size(); i3++) {
                jSONArray.put(biW.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.setFeedBackReasonMap(sparseArray);
            ajVar.hv(i);
            ajVar.F(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.biU().getForumId());
            this.fWw.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fWw.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fWs != null) {
            this.fWs.a((d.a) null);
            this.fWs.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fWs != null) {
            this.fWs.a(aVar);
        }
    }
}
