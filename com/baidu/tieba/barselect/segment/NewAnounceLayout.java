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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes15.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float ekM;
    private View.OnClickListener eve;
    private View gSR;
    private TextView gSS;
    private View gST;
    private TextView gSU;
    private TextView gSV;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ap("c13447").baO();
                if (NewAnounceLayout.this.gSQ != null && NewAnounceLayout.this.gSQ.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.gSQ.bQx())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.gSQ.getTid() + "", (String) null, (String) null, true);
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
        ss();
    }

    private void ss() {
        this.gSR = findViewById(R.id.announce_content);
        this.gSR.setOnClickListener(this.eve);
        this.gSS = (TextView) findViewById(R.id.first_line_tv);
        this.gST = findViewById(R.id.second_content);
        this.gSU = (TextView) findViewById(R.id.second_line_tv);
        this.gSV = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.gPf == null || this.gSQ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.ekM = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.gTe) {
            this.ekM = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.gTg) {
            this.ekM = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.gTf) {
            this.ekM = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.gSR.setPadding(0, 0, 0, 0);
            this.gSS.setPadding(0, 0, 0, 0);
            this.gSU.setPadding(0, 0, 0, 0);
            this.gSV.setPadding(0, 0, 0, 0);
        }
        Ex(this.gSQ.bQx());
    }

    private void Ex(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.gST.setVisibility(8);
            this.gSS.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.gST.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.gSS.getPaint(), (int) this.ekM, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.gST.setVisibility(8);
            this.gSS.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.gSU.getPaint(), (int) this.ekM, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.gSV.setVisibility(8);
        } else {
            this.gSV.setVisibility(0);
        }
        this.gST.setVisibility(0);
        this.gSS.setText(substring);
        this.gSU.setText(substring2);
    }

    public void qZ(int i) {
        if (this.gSQ != null) {
            if (this.status != a.gTf) {
                ao.setBackgroundColor(this.gSR, R.color.cp_bg_line_e, i);
            } else if (this.gSR != null) {
                this.gSR.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.gSQ.bQx())) {
                ao.setViewTextColor(this.gSS, R.color.cp_cont_d, 1, i);
            } else {
                ao.setViewTextColor(this.gSS, R.color.cp_cont_b, 1, i);
            }
            ao.setViewTextColor(this.gSU, R.color.cp_cont_b, 1, i);
            ao.setViewTextColor(this.gSV, R.color.cp_link_tip_c, 1, i);
        }
    }
}
