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
/* loaded from: classes5.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float dec;
    private View.OnClickListener dmK;
    private View fAi;
    private TextView fAj;
    private View fAk;
    private TextView fAl;
    private TextView fAm;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aDT();
                if (NewAnounceLayout.this.fAh != null && NewAnounceLayout.this.fAh.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.fAh.brp())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.fAh.getTid() + "", (String) null, (String) null, true);
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
        na();
    }

    private void na() {
        this.fAi = findViewById(R.id.announce_content);
        this.fAi.setOnClickListener(this.dmK);
        this.fAj = (TextView) findViewById(R.id.first_line_tv);
        this.fAk = findViewById(R.id.second_content);
        this.fAl = (TextView) findViewById(R.id.second_line_tv);
        this.fAm = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.fww == null || this.fAh == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dec = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.fAw) {
            this.dec = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.fAy) {
            this.dec = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.fAx) {
            this.dec = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.fAi.setPadding(0, 0, 0, 0);
            this.fAj.setPadding(0, 0, 0, 0);
            this.fAl.setPadding(0, 0, 0, 0);
            this.fAm.setPadding(0, 0, 0, 0);
        }
        zq(this.fAh.brp());
    }

    private void zq(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.fAk.setVisibility(8);
            this.fAj.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.fAk.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.fAj.getPaint(), (int) this.dec, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.fAk.setVisibility(8);
            this.fAj.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.fAl.getPaint(), (int) this.dec, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.fAm.setVisibility(8);
        } else {
            this.fAm.setVisibility(0);
        }
        this.fAk.setVisibility(0);
        this.fAj.setText(substring);
        this.fAl.setText(substring2);
    }

    public void oT(int i) {
        if (this.fAh != null) {
            if (this.status != a.fAx) {
                am.setBackgroundColor(this.fAi, R.color.cp_bg_line_e, i);
            } else if (this.fAi != null) {
                this.fAi.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.fAh.brp())) {
                am.setViewTextColor(this.fAj, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.fAj, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.fAl, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fAm, R.color.cp_link_tip_c, 1, i);
        }
    }
}
