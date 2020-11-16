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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes21.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bHW;
    private TextView iZB;
    private final com.baidu.tieba.NEGFeedBack.d jot;
    private TextView jou;
    private TextView jov;
    private View jow;
    private com.baidu.tieba.NEGFeedBack.e jox;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jot = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.iZB = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.iZB.setText(R.string.cancel);
        this.jou = (TextView) findViewById(R.id.multi_del_btn);
        this.jou.setText(R.string.delete);
        this.jov = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jov.setText(R.string.delete_and_forbidden_one_day);
        this.bHW = findViewById(R.id.divider_top_line);
        this.jow = findViewById(R.id.divider);
        this.iZB.setOnClickListener(this);
        this.jou.setOnClickListener(this);
        this.jov.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jou.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.iZB, R.color.CAM_X0105);
        ap.setBackgroundResource(this.iZB, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jov, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jov, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jou, R.color.CAM_X0301);
        ap.setBackgroundResource(this.jou, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bHW, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jow, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jot.registerListener();
        if (view == this.iZB) {
            com.baidu.tieba.frs.b.cwO().reset();
        } else if (view == this.jou) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cwO().cwL())) {
                TiebaStatic.log(new ar("c13122").ak("obj_type", 1));
                setData(1);
                KF("2");
            }
        } else if (view == this.jov && !y.isEmpty(com.baidu.tieba.frs.b.cwO().cwL())) {
            TiebaStatic.log(new ar("c13122").ak("obj_type", 2));
            setData(2);
            KF("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void KF(String str) {
        if (this.pageContext != null) {
            if (this.jox == null) {
                this.jox = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.jox.Ev(str);
        }
    }

    public void czx() {
        if (this.jox != null) {
            this.jox.bHT();
        }
    }

    public void bHP() {
        if (this.jox != null) {
            this.jox.bHP();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jox == null) {
                this.jox = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cwP = com.baidu.tieba.frs.b.cwO().cwP();
            if (cwP != null && cwP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cwP.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bx> cwL = com.baidu.tieba.frs.b.cwO().cwL();
            for (int i3 = 0; i3 < cwL.size(); i3++) {
                jSONArray.put(cwL.get(i3).getTid());
            }
            as asVar = new as();
            asVar.setFeedBackReasonMap(sparseArray);
            asVar.nS(i);
            asVar.P(jSONArray);
            asVar.setFid(com.baidu.tieba.frs.b.cwO().getForumId());
            this.jox.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jox.setData(asVar);
        }
    }

    public void onDestroy() {
        if (this.jot != null) {
            this.jot.a((d.a) null);
            this.jot.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.jot != null) {
            this.jot.a(aVar);
        }
    }
}
