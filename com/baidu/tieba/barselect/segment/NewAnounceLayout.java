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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float dIR;
    private View.OnClickListener dRK;
    private View glA;
    private TextView glB;
    private TextView glC;
    private View gly;
    private TextView glz;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aOO();
                if (NewAnounceLayout.this.glx != null && NewAnounceLayout.this.glx.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.glx.bDN())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.glx.getTid() + "", (String) null, (String) null, true);
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
        rL();
    }

    private void rL() {
        this.gly = findViewById(R.id.announce_content);
        this.gly.setOnClickListener(this.dRK);
        this.glz = (TextView) findViewById(R.id.first_line_tv);
        this.glA = findViewById(R.id.second_content);
        this.glB = (TextView) findViewById(R.id.second_line_tv);
        this.glC = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ghJ == null || this.glx == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dIR = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.glM) {
            this.dIR = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.glO) {
            this.dIR = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.glN) {
            this.dIR = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.gly.setPadding(0, 0, 0, 0);
            this.glz.setPadding(0, 0, 0, 0);
            this.glB.setPadding(0, 0, 0, 0);
            this.glC.setPadding(0, 0, 0, 0);
        }
        BC(this.glx.bDN());
    }

    private void BC(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.glA.setVisibility(8);
            this.glz.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.glA.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.glz.getPaint(), (int) this.dIR, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.glA.setVisibility(8);
            this.glz.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.glB.getPaint(), (int) this.dIR, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.glC.setVisibility(8);
        } else {
            this.glC.setVisibility(0);
        }
        this.glA.setVisibility(0);
        this.glz.setText(substring);
        this.glB.setText(substring2);
    }

    public void pH(int i) {
        if (this.glx != null) {
            if (this.status != a.glN) {
                am.setBackgroundColor(this.gly, R.color.cp_bg_line_e, i);
            } else if (this.gly != null) {
                this.gly.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.glx.bDN())) {
                am.setViewTextColor(this.glz, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.glz, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.glB, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.glC, R.color.cp_link_tip_c, 1, i);
        }
    }
}
