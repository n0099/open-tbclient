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
/* loaded from: classes15.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private View.OnClickListener eFG;
    private float euL;
    private View hfO;
    private TextView hfP;
    private View hfQ;
    private TextView hfR;
    private TextView hfS;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").bjn();
                if (NewAnounceLayout.this.hfN != null && NewAnounceLayout.this.hfN.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hfN.caJ())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hfN.getTid() + "", (String) null, (String) null, true);
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
        uf();
    }

    private void uf() {
        this.hfO = findViewById(R.id.announce_content);
        this.hfO.setOnClickListener(this.eFG);
        this.hfP = (TextView) findViewById(R.id.first_line_tv);
        this.hfQ = findViewById(R.id.second_content);
        this.hfR = (TextView) findViewById(R.id.second_line_tv);
        this.hfS = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hbZ == null || this.hfN == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.euL = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hgb) {
            this.euL = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hgd) {
            this.euL = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hgc) {
            this.euL = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hfO.setPadding(0, 0, 0, 0);
            this.hfP.setPadding(0, 0, 0, 0);
            this.hfR.setPadding(0, 0, 0, 0);
            this.hfS.setPadding(0, 0, 0, 0);
        }
        GX(this.hfN.caJ());
    }

    private void GX(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hfQ.setVisibility(8);
            this.hfP.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hfQ.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hfP.getPaint(), (int) this.euL, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hfQ.setVisibility(8);
            this.hfP.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hfR.getPaint(), (int) this.euL, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hfS.setVisibility(8);
        } else {
            this.hfS.setVisibility(0);
        }
        this.hfQ.setVisibility(0);
        this.hfP.setText(substring);
        this.hfR.setText(substring2);
    }

    public void tl(int i) {
        if (this.hfN != null) {
            if (this.status != a.hgc) {
                ap.setBackgroundColor(this.hfO, R.color.cp_bg_line_e, i);
            } else if (this.hfO != null) {
                this.hfO.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hfN.caJ())) {
                ap.setViewTextColor(this.hfP, R.color.cp_cont_d, 1, i);
            } else {
                ap.setViewTextColor(this.hfP, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.hfR, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hfS, R.color.cp_link_tip_c, 1, i);
        }
    }
}
