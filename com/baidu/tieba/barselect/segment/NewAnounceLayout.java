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
/* loaded from: classes6.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float dem;
    private View.OnClickListener dmY;
    private View fDt;
    private TextView fDu;
    private View fDv;
    private TextView fDw;
    private TextView fDx;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aEm();
                if (NewAnounceLayout.this.fDs != null && NewAnounceLayout.this.fDs.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.fDs.bsr())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.fDs.getTid() + "", (String) null, (String) null, true);
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
        nb();
    }

    private void nb() {
        this.fDt = findViewById(R.id.announce_content);
        this.fDt.setOnClickListener(this.dmY);
        this.fDu = (TextView) findViewById(R.id.first_line_tv);
        this.fDv = findViewById(R.id.second_content);
        this.fDw = (TextView) findViewById(R.id.second_line_tv);
        this.fDx = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.fzH == null || this.fDs == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dem = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.fDH) {
            this.dem = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.fDJ) {
            this.dem = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.fDI) {
            this.dem = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.fDt.setPadding(0, 0, 0, 0);
            this.fDu.setPadding(0, 0, 0, 0);
            this.fDw.setPadding(0, 0, 0, 0);
            this.fDx.setPadding(0, 0, 0, 0);
        }
        zA(this.fDs.bsr());
    }

    private void zA(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.fDv.setVisibility(8);
            this.fDu.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.fDv.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.fDu.getPaint(), (int) this.dem, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.fDv.setVisibility(8);
            this.fDu.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.fDw.getPaint(), (int) this.dem, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.fDx.setVisibility(8);
        } else {
            this.fDx.setVisibility(0);
        }
        this.fDv.setVisibility(0);
        this.fDu.setText(substring);
        this.fDw.setText(substring2);
    }

    public void oU(int i) {
        if (this.fDs != null) {
            if (this.status != a.fDI) {
                am.setBackgroundColor(this.fDt, R.color.cp_bg_line_e, i);
            } else if (this.fDt != null) {
                this.fDt.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.fDs.bsr())) {
                am.setViewTextColor(this.fDu, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.fDu, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.fDw, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fDx, R.color.cp_link_tip_c, 1, i);
        }
    }
}
