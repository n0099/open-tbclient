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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View hKh;
    private TextView hQn;
    private final com.baidu.tieba.NEGFeedBack.d ieQ;
    private TextView ieR;
    private TextView ieS;
    private View ieT;
    private com.baidu.tieba.NEGFeedBack.e ieU;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.ieQ = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hQn = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hQn.setText(R.string.cancel);
        this.ieR = (TextView) findViewById(R.id.multi_del_btn);
        this.ieR.setText(R.string.delete);
        this.ieS = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.ieS.setText(R.string.delete_and_forbidden_one_day);
        this.hKh = findViewById(R.id.divider_top_line);
        this.ieT = findViewById(R.id.divider);
        this.hQn.setOnClickListener(this);
        this.ieR.setOnClickListener(this);
        this.ieS.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ieR.setText(string);
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setViewTextColor(this.hQn, (int) R.color.cp_cont_b);
        an.setBackgroundResource(this.hQn, R.drawable.bg_bottom_up_list_dialog_item);
        an.setViewTextColor(this.ieS, (int) R.color.cp_cont_b);
        an.setBackgroundResource(this.ieS, R.drawable.bg_bottom_up_list_dialog_item);
        an.setViewTextColor(this.ieR, (int) R.color.cp_cont_h);
        an.setBackgroundResource(this.ieR, R.drawable.bg_bottom_up_list_dialog_item);
        an.setBackgroundColor(this.hKh, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.ieT, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ieQ.registerListener();
        if (view == this.hQn) {
            com.baidu.tieba.frs.b.bXd().reset();
        } else if (view == this.ieR) {
            if (!w.isEmpty(com.baidu.tieba.frs.b.bXd().bXa())) {
                TiebaStatic.log(new ao("c13122").ag("obj_type", 1));
                setData(1);
                FO("2");
            }
        } else if (view == this.ieS && !w.isEmpty(com.baidu.tieba.frs.b.bXd().bXa())) {
            TiebaStatic.log(new ao("c13122").ag("obj_type", 2));
            setData(2);
            FO("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void FO(String str) {
        if (this.pageContext != null) {
            if (this.ieU == null) {
                this.ieU = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.ieU.zC(str);
        }
    }

    public void bZH() {
        if (this.ieU != null) {
            this.ieU.bnt();
        }
    }

    public void bnq() {
        if (this.ieU != null) {
            this.ieU.bnq();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.ieU == null) {
                this.ieU = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bXe = com.baidu.tieba.frs.b.bXd().bXe();
            if (bXe != null && bXe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bXe.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bu> bXa = com.baidu.tieba.frs.b.bXd().bXa();
            for (int i3 = 0; i3 < bXa.size(); i3++) {
                jSONArray.put(bXa.get(i3).getTid());
            }
            ap apVar = new ap();
            apVar.setFeedBackReasonMap(sparseArray);
            apVar.kt(i);
            apVar.M(jSONArray);
            apVar.setFid(com.baidu.tieba.frs.b.bXd().getForumId());
            this.ieU.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.ieU.setData(apVar);
        }
    }

    public void onDestroy() {
        if (this.ieQ != null) {
            this.ieQ.a((d.a) null);
            this.ieQ.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.ieQ != null) {
            this.ieQ.a(aVar);
        }
    }
}
