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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes22.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bNe;
    private final com.baidu.tieba.NEGFeedBack.e jBX;
    private TextView jBY;
    private TextView jBZ;
    private View jCa;
    private com.baidu.tieba.NEGFeedBack.f jCb;
    private TextView jnd;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jBX = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.jnd = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.jnd.setText(R.string.cancel);
        this.jBY = (TextView) findViewById(R.id.multi_del_btn);
        this.jBY.setText(R.string.delete);
        this.jBZ = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jBZ.setText(R.string.delete_and_forbidden_one_day);
        this.bNe = findViewById(R.id.divider_top_line);
        this.jCa = findViewById(R.id.divider);
        this.jnd.setOnClickListener(this);
        this.jBY.setOnClickListener(this);
        this.jBZ.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jBY.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.jnd, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jnd, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jBZ, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jBZ, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jBY, R.color.CAM_X0301);
        ap.setBackgroundResource(this.jBY, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bNe, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jCa, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jBX.registerListener();
        if (view == this.jnd) {
            com.baidu.tieba.frs.b.cBe().reset();
        } else if (view == this.jBY) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cBe().cBb())) {
                TiebaStatic.log(new ar("c13122").al("obj_type", 1));
                setData(1);
                LM("2");
            }
        } else if (view == this.jBZ && !y.isEmpty(com.baidu.tieba.frs.b.cBe().cBb())) {
            TiebaStatic.log(new ar("c13122").al("obj_type", 2));
            setData(2);
            LM("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void LM(String str) {
        if (this.pageContext != null) {
            if (this.jCb == null) {
                this.jCb = new com.baidu.tieba.NEGFeedBack.f(this.pageContext, this);
            }
            this.jCb.Fj(str);
        }
    }

    public void cDO() {
        if (this.jCb != null) {
            this.jCb.bLu();
        }
    }

    public void bLq() {
        if (this.jCb != null) {
            this.jCb.bLq();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jCb == null) {
                this.jCb = new com.baidu.tieba.NEGFeedBack.f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cBf = com.baidu.tieba.frs.b.cBe().cBf();
            if (cBf != null && cBf.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBf.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<by> cBb = com.baidu.tieba.frs.b.cBe().cBb();
            for (int i3 = 0; i3 < cBb.size(); i3++) {
                jSONArray.put(cBb.get(i3).getTid());
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            atVar.oq(i);
            atVar.Q(jSONArray);
            atVar.setFid(com.baidu.tieba.frs.b.cBe().getForumId());
            this.jCb.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jCb.setData(atVar);
        }
    }

    public void onDestroy() {
        if (this.jBX != null) {
            this.jBX.a((e.a) null);
            this.jBX.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jBX != null) {
            this.jBX.a(aVar);
        }
    }
}
