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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes16.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View hQh;
    private TextView hWm;
    private final com.baidu.tieba.NEGFeedBack.d ikQ;
    private TextView ikR;
    private TextView ikS;
    private View ikT;
    private com.baidu.tieba.NEGFeedBack.e ikU;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.ikQ = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hWm = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hWm.setText(R.string.cancel);
        this.ikR = (TextView) findViewById(R.id.multi_del_btn);
        this.ikR.setText(R.string.delete);
        this.ikS = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.ikS.setText(R.string.delete_and_forbidden_one_day);
        this.hQh = findViewById(R.id.divider_top_line);
        this.ikT = findViewById(R.id.divider);
        this.hWm.setOnClickListener(this);
        this.ikR.setOnClickListener(this);
        this.ikS.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ikR.setText(string);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.hWm, R.color.cp_cont_b);
        ao.setBackgroundResource(this.hWm, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.ikS, R.color.cp_cont_b);
        ao.setBackgroundResource(this.ikS, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.ikR, R.color.cp_cont_h);
        ao.setBackgroundResource(this.ikR, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.hQh, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.ikT, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ikQ.registerListener();
        if (view == this.hWm) {
            com.baidu.tieba.frs.b.caw().reset();
        } else if (view == this.ikR) {
            if (!x.isEmpty(com.baidu.tieba.frs.b.caw().cat())) {
                TiebaStatic.log(new ap("c13122").ah("obj_type", 1));
                setData(1);
                GA("2");
            }
        } else if (view == this.ikS && !x.isEmpty(com.baidu.tieba.frs.b.caw().cat())) {
            TiebaStatic.log(new ap("c13122").ah("obj_type", 2));
            setData(2);
            GA("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void GA(String str) {
        if (this.pageContext != null) {
            if (this.ikU == null) {
                this.ikU = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.ikU.AK(str);
        }
    }

    public void cde() {
        if (this.ikU != null) {
            this.ikU.bro();
        }
    }

    public void brl() {
        if (this.ikU != null) {
            this.ikU.brl();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.ikU == null) {
                this.ikU = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cax = com.baidu.tieba.frs.b.caw().cax();
            if (cax != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bv> cat = com.baidu.tieba.frs.b.caw().cat();
            for (int i3 = 0; i3 < cat.size(); i3++) {
                jSONArray.put(cat.get(i3).getTid());
            }
            aq aqVar = new aq();
            aqVar.setFeedBackReasonMap(sparseArray);
            aqVar.kN(i);
            aqVar.N(jSONArray);
            aqVar.setFid(com.baidu.tieba.frs.b.caw().getForumId());
            this.ikU.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.ikU.setData(aqVar);
        }
    }

    public void onDestroy() {
        if (this.ikQ != null) {
            this.ikQ.a((d.a) null);
            this.ikQ.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.ikQ != null) {
            this.ikQ.a(aVar);
        }
    }
}
