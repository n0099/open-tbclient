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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes21.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float eXk;
    private View.OnClickListener fii;
    private View hUc;
    private TextView hUd;
    private View hUe;
    private TextView hUf;
    private TextView hUg;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").brk();
                if (NewAnounceLayout.this.hUb != null && NewAnounceLayout.this.hUb.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hUb.cnb()) && NewAnounceLayout.this.hUb.cnd() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hUb.getTid() + "", (String) null, (String) null, true);
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
        ul();
    }

    private void ul() {
        this.hUc = findViewById(R.id.announce_content);
        this.hUc.setOnClickListener(this.fii);
        this.hUd = (TextView) findViewById(R.id.first_line_tv);
        this.hUe = findViewById(R.id.second_content);
        this.hUf = (TextView) findViewById(R.id.second_line_tv);
        this.hUg = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hQm == null || this.hUb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eXk = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hUp) {
            this.eXk = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hUr) {
            this.eXk = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hUq) {
            this.eXk = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hUc.setPadding(0, 0, 0, 0);
            this.hUd.setPadding(0, 0, 0, 0);
            this.hUf.setPadding(0, 0, 0, 0);
            this.hUg.setPadding(0, 0, 0, 0);
        }
        IX(this.hUb.cnb());
    }

    private void IX(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hUe.setVisibility(8);
            this.hUd.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hUe.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hUd.getPaint(), (int) this.eXk, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hUe.setVisibility(8);
            this.hUd.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hUf.getPaint(), (int) this.eXk, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hUg.setVisibility(8);
        } else {
            this.hUg.setVisibility(0);
        }
        this.hUe.setVisibility(0);
        this.hUd.setText(substring);
        this.hUf.setText(substring2);
    }

    public void uE(int i) {
        if (this.hUb != null) {
            if (this.status != a.hUq) {
                ap.setBackgroundColor(this.hUc, R.color.cp_bg_line_e, i);
            } else if (this.hUc != null) {
                this.hUc.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hUb.cnb())) {
                ap.setViewTextColor(this.hUd, R.color.cp_cont_d, 1, i);
            } else {
                ap.setViewTextColor(this.hUd, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.hUf, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hUg, R.color.cp_link_tip_c, 1, i);
        }
    }
}
