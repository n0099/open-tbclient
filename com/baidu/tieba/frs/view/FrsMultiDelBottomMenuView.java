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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bNf;
    private final com.baidu.tieba.NEGFeedBack.e jJT;
    private TextView jJU;
    private TextView jJV;
    private View jJW;
    private f jJX;
    private TextView juV;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jJT = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.juV = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.juV.setText(R.string.cancel);
        this.jJU = (TextView) findViewById(R.id.multi_del_btn);
        this.jJU.setText(R.string.delete);
        this.jJV = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jJV.setText(R.string.delete_and_forbidden_one_day);
        this.bNf = findViewById(R.id.divider_top_line);
        this.jJW = findViewById(R.id.divider);
        this.juV.setOnClickListener(this);
        this.jJU.setOnClickListener(this);
        this.jJV.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jJU.setText(string);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this.juV, R.color.CAM_X0105);
        ao.setBackgroundResource(this.juV, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.jJV, R.color.CAM_X0105);
        ao.setBackgroundResource(this.jJV, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.jJU, R.color.CAM_X0301);
        ao.setBackgroundResource(this.jJU, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.bNf, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jJW, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jJT.registerListener();
        if (view == this.juV) {
            com.baidu.tieba.frs.b.cAg().reset();
        } else if (view == this.jJU) {
            if (!x.isEmpty(com.baidu.tieba.frs.b.cAg().cAd())) {
                TiebaStatic.log(new aq("c13122").an("obj_type", 1));
                setData(1);
                KB("2");
            }
        } else if (view == this.jJV && !x.isEmpty(com.baidu.tieba.frs.b.cAg().cAd())) {
            TiebaStatic.log(new aq("c13122").an("obj_type", 2));
            setData(2);
            KB("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void KB(String str) {
        if (this.pageContext != null) {
            if (this.jJX == null) {
                this.jJX = new f(this.pageContext, this);
            }
            this.jJX.DV(str);
        }
    }

    public void cCR() {
        if (this.jJX != null) {
            this.jJX.bJV();
        }
    }

    public void bJR() {
        if (this.jJX != null) {
            this.jJX.bJR();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jJX == null) {
                this.jJX = new f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cAh = com.baidu.tieba.frs.b.cAg().cAh();
            if (cAh != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bz> cAd = com.baidu.tieba.frs.b.cAg().cAd();
            for (int i3 = 0; i3 < cAd.size(); i3++) {
                jSONArray.put(cAd.get(i3).getTid());
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            atVar.mU(i);
            atVar.Q(jSONArray);
            atVar.setFid(com.baidu.tieba.frs.b.cAg().getForumId());
            this.jJX.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jJX.setData(atVar);
        }
    }

    public void onDestroy() {
        if (this.jJT != null) {
            this.jJT.a((e.a) null);
            this.jJT.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jJT != null) {
            this.jJT.a(aVar);
        }
    }
}
