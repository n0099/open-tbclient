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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bSv;
    private TextView jCy;
    private final com.baidu.tieba.NEGFeedBack.e jSN;
    private TextView jSO;
    private TextView jSP;
    private View jSQ;
    private f jSR;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jSN = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.jCy = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.jCy.setText(R.string.cancel);
        this.jSO = (TextView) findViewById(R.id.multi_del_btn);
        this.jSO.setText(R.string.delete);
        this.jSP = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jSP.setText(R.string.delete_and_forbidden_one_day);
        this.bSv = findViewById(R.id.divider_top_line);
        this.jSQ = findViewById(R.id.divider);
        this.jCy.setOnClickListener(this);
        this.jSO.setOnClickListener(this);
        this.jSP.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jSO.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.jCy, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jCy, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jSP, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jSP, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jSO, R.color.CAM_X0301);
        ap.setBackgroundResource(this.jSO, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bSv, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jSQ, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jSN.registerListener();
        if (view == this.jCy) {
            com.baidu.tieba.frs.b.cBE().reset();
        } else if (view == this.jSO) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cBE().cBB())) {
                TiebaStatic.log(new ar("c13122").aq("obj_type", 1));
                setData(1);
                Ly("2");
            }
        } else if (view == this.jSP && !y.isEmpty(com.baidu.tieba.frs.b.cBE().cBB())) {
            TiebaStatic.log(new ar("c13122").aq("obj_type", 2));
            setData(2);
            Ly("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Ly(String str) {
        if (this.pageContext != null) {
            if (this.jSR == null) {
                this.jSR = new f(this.pageContext, this);
            }
            this.jSR.Ey(str);
        }
    }

    public void cEq() {
        if (this.jSR != null) {
            this.jSR.bKy();
        }
    }

    public void bKu() {
        if (this.jSR != null) {
            this.jSR.bKu();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jSR == null) {
                this.jSR = new f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cBF = com.baidu.tieba.frs.b.cBE().cBF();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<cb> cBB = com.baidu.tieba.frs.b.cBE().cBB();
            for (int i3 = 0; i3 < cBB.size(); i3++) {
                jSONArray.put(cBB.get(i3).getTid());
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            avVar.mY(i);
            avVar.P(jSONArray);
            avVar.setFid(com.baidu.tieba.frs.b.cBE().getForumId());
            this.jSR.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jSR.setData(avVar);
        }
    }

    public void onDestroy() {
        if (this.jSN != null) {
            this.jSN.a((e.a) null);
            this.jSN.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jSN != null) {
            this.jSN.a(aVar);
        }
    }
}
