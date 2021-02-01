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
    private View bQV;
    private TextView jAB;
    private final com.baidu.tieba.NEGFeedBack.e jQQ;
    private TextView jQR;
    private TextView jQS;
    private View jQT;
    private f jQU;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jQQ = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.jAB = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.jAB.setText(R.string.cancel);
        this.jQR = (TextView) findViewById(R.id.multi_del_btn);
        this.jQR.setText(R.string.delete);
        this.jQS = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jQS.setText(R.string.delete_and_forbidden_one_day);
        this.bQV = findViewById(R.id.divider_top_line);
        this.jQT = findViewById(R.id.divider);
        this.jAB.setOnClickListener(this);
        this.jQR.setOnClickListener(this);
        this.jQS.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jQR.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.jAB, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jAB, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jQS, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jQS, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jQR, R.color.CAM_X0301);
        ap.setBackgroundResource(this.jQR, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bQV, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jQT, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jQQ.registerListener();
        if (view == this.jAB) {
            com.baidu.tieba.frs.b.cBr().reset();
        } else if (view == this.jQR) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cBr().cBo())) {
                TiebaStatic.log(new ar("c13122").ap("obj_type", 1));
                setData(1);
                Lo("2");
            }
        } else if (view == this.jQS && !y.isEmpty(com.baidu.tieba.frs.b.cBr().cBo())) {
            TiebaStatic.log(new ar("c13122").ap("obj_type", 2));
            setData(2);
            Lo("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Lo(String str) {
        if (this.pageContext != null) {
            if (this.jQU == null) {
                this.jQU = new f(this.pageContext, this);
            }
            this.jQU.Et(str);
        }
    }

    public void cEd() {
        if (this.jQU != null) {
            this.jQU.bKp();
        }
    }

    public void bKl() {
        if (this.jQU != null) {
            this.jQU.bKl();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jQU == null) {
                this.jQU = new f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cBs = com.baidu.tieba.frs.b.cBr().cBs();
            if (cBs != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<cb> cBo = com.baidu.tieba.frs.b.cBr().cBo();
            for (int i3 = 0; i3 < cBo.size(); i3++) {
                jSONArray.put(cBo.get(i3).getTid());
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            avVar.mX(i);
            avVar.P(jSONArray);
            avVar.setFid(com.baidu.tieba.frs.b.cBr().getForumId());
            this.jQU.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jQU.setData(avVar);
        }
    }

    public void onDestroy() {
        if (this.jQQ != null) {
            this.jQQ.a((e.a) null);
            this.jQQ.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jQQ != null) {
            this.jQQ.a(aVar);
        }
    }
}
