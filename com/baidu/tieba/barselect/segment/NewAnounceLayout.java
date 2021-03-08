package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes7.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float fmF;
    private View iuQ;
    private TextView iuR;
    private View iuS;
    private TextView iuT;
    private TextView iuU;
    private Context mContext;
    private View.OnClickListener onClickListener;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ar("c13447").bsR();
                if (NewAnounceLayout.this.iuP != null && NewAnounceLayout.this.iuP.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.iuP.crq()) && NewAnounceLayout.this.iuP.crs() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.iuP.getTid() + "", (String) null, (String) null, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        initUI();
    }

    protected void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.new_announce_layout, (ViewGroup) this, true);
        tz();
    }

    private void tz() {
        this.iuQ = findViewById(R.id.announce_content);
        this.iuQ.setOnClickListener(this.onClickListener);
        this.iuR = (TextView) findViewById(R.id.first_line_tv);
        this.iuS = findViewById(R.id.second_content);
        this.iuT = (TextView) findViewById(R.id.second_line_tv);
        this.iuU = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ire == null || this.iuP == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fmF = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.ivd) {
            this.fmF = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.ivf) {
            this.fmF = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.ive) {
            this.fmF = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.iuQ.setPadding(0, 0, 0, 0);
            this.iuR.setPadding(0, 0, 0, 0);
            this.iuT.setPadding(0, 0, 0, 0);
            this.iuU.setPadding(0, 0, 0, 0);
        }
        IU(this.iuP.crq());
    }

    private void IU(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.iuS.setVisibility(8);
            this.iuR.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.iuS.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.iuR.getPaint(), (int) this.fmF, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.iuS.setVisibility(8);
            this.iuR.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.iuT.getPaint(), (int) this.fmF, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.iuU.setVisibility(8);
        } else {
            this.iuU.setVisibility(0);
        }
        this.iuS.setVisibility(0);
        this.iuR.setText(substring);
        this.iuT.setText(substring2);
    }

    public void uw(int i) {
        if (this.iuP != null) {
            if (this.status != a.ive) {
                ap.setBackgroundColor(this.iuQ, R.color.CAM_X0205, i);
            } else if (this.iuQ != null) {
                this.iuQ.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.iuP.crq())) {
                ap.setViewTextColor(this.iuR, R.color.CAM_X0109, 1, i);
            } else {
                ap.setViewTextColor(this.iuR, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.iuT, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.iuU, R.color.CAM_X0304, 1, i);
        }
    }
}
