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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView hCs;
    private final com.baidu.tieba.NEGFeedBack.d hQt;
    private TextView hQu;
    private TextView hQv;
    private View hQw;
    private e hQx;
    private View hwY;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.hQt = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hCs = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hCs.setText(R.string.cancel);
        this.hQu = (TextView) findViewById(R.id.multi_del_btn);
        this.hQu.setText(R.string.delete);
        this.hQv = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.hQv.setText(R.string.delete_and_forbidden_one_day);
        this.hwY = findViewById(R.id.divider_top_line);
        this.hQw = findViewById(R.id.divider);
        this.hCs.setOnClickListener(this);
        this.hQu.setOnClickListener(this);
        this.hQv.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.hQu.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hCs, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hCs, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hQv, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hQv, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hQu, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.hQu, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.hwY, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hQw, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.hQt.registerListener();
        if (view == this.hCs) {
            com.baidu.tieba.frs.a.bTX().reset();
        } else if (view == this.hQu) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bTX().bTZ())) {
                TiebaStatic.log(new an("c13122").ag("obj_type", 1));
                setData(1);
                Fn("2");
            }
        } else if (view == this.hQv && !v.isEmpty(com.baidu.tieba.frs.a.bTX().bTZ())) {
            TiebaStatic.log(new an("c13122").ag("obj_type", 2));
            setData(2);
            Fn("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Fn(String str) {
        if (this.pageContext != null) {
            if (this.hQx == null) {
                this.hQx = new e(this.pageContext, this);
            }
            this.hQx.zj(str);
        }
    }

    public void bWu() {
        if (this.hQx != null) {
            this.hQx.bkR();
        }
    }

    public void bkO() {
        if (this.hQx != null) {
            this.hQx.bkO();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.hQx == null) {
                this.hQx = new e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bUa = com.baidu.tieba.frs.a.bTX().bUa();
            if (bUa != null && bUa.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUa.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bk> bTZ = com.baidu.tieba.frs.a.bTX().bTZ();
            for (int i3 = 0; i3 < bTZ.size(); i3++) {
                jSONArray.put(bTZ.get(i3).getTid());
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray);
            akVar.kf(i);
            akVar.M(jSONArray);
            akVar.setFid(com.baidu.tieba.frs.a.bTX().getForumId());
            this.hQx.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.hQx.setData(akVar);
        }
    }

    public void onDestroy() {
        if (this.hQt != null) {
            this.hQt.a((d.a) null);
            this.hQt.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.hQt != null) {
            this.hQt.a(aVar);
        }
    }
}
