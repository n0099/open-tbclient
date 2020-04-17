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
    private float dIN;
    private View.OnClickListener dRF;
    private View gls;
    private TextView glt;
    private View glu;
    private TextView glv;
    private TextView glw;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aOR();
                if (NewAnounceLayout.this.glr != null && NewAnounceLayout.this.glr.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.glr.bDO())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.glr.getTid() + "", (String) null, (String) null, true);
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
        this.gls = findViewById(R.id.announce_content);
        this.gls.setOnClickListener(this.dRF);
        this.glt = (TextView) findViewById(R.id.first_line_tv);
        this.glu = findViewById(R.id.second_content);
        this.glv = (TextView) findViewById(R.id.second_line_tv);
        this.glw = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ghD == null || this.glr == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dIN = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.glG) {
            this.dIN = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.glI) {
            this.dIN = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.glH) {
            this.dIN = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.gls.setPadding(0, 0, 0, 0);
            this.glt.setPadding(0, 0, 0, 0);
            this.glv.setPadding(0, 0, 0, 0);
            this.glw.setPadding(0, 0, 0, 0);
        }
        Bz(this.glr.bDO());
    }

    private void Bz(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.glu.setVisibility(8);
            this.glt.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.glu.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.glt.getPaint(), (int) this.dIN, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.glu.setVisibility(8);
            this.glt.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.glv.getPaint(), (int) this.dIN, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.glw.setVisibility(8);
        } else {
            this.glw.setVisibility(0);
        }
        this.glu.setVisibility(0);
        this.glt.setText(substring);
        this.glv.setText(substring2);
    }

    public void pH(int i) {
        if (this.glr != null) {
            if (this.status != a.glH) {
                am.setBackgroundColor(this.gls, R.color.cp_bg_line_e, i);
            } else if (this.gls != null) {
                this.gls.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.glr.bDO())) {
                am.setViewTextColor(this.glt, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.glt, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.glv, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.glw, R.color.cp_link_tip_c, 1, i);
        }
    }
}
