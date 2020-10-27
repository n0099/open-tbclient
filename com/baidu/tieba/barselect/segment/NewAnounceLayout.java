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
    private float eRv;
    private View.OnClickListener fcr;
    private View hOf;
    private TextView hOg;
    private View hOh;
    private TextView hOi;
    private TextView hOj;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").boK();
                if (NewAnounceLayout.this.hOe != null && NewAnounceLayout.this.hOe.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hOe.ckz()) && NewAnounceLayout.this.hOe.ckB() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hOe.getTid() + "", (String) null, (String) null, true);
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
        this.hOf = findViewById(R.id.announce_content);
        this.hOf.setOnClickListener(this.fcr);
        this.hOg = (TextView) findViewById(R.id.first_line_tv);
        this.hOh = findViewById(R.id.second_content);
        this.hOi = (TextView) findViewById(R.id.second_line_tv);
        this.hOj = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hKp == null || this.hOe == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eRv = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hOs) {
            this.eRv = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hOu) {
            this.eRv = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hOt) {
            this.eRv = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hOf.setPadding(0, 0, 0, 0);
            this.hOg.setPadding(0, 0, 0, 0);
            this.hOi.setPadding(0, 0, 0, 0);
            this.hOj.setPadding(0, 0, 0, 0);
        }
        IG(this.hOe.ckz());
    }

    private void IG(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hOh.setVisibility(8);
            this.hOg.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hOh.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hOg.getPaint(), (int) this.eRv, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hOh.setVisibility(8);
            this.hOg.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hOi.getPaint(), (int) this.eRv, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hOj.setVisibility(8);
        } else {
            this.hOj.setVisibility(0);
        }
        this.hOh.setVisibility(0);
        this.hOg.setText(substring);
        this.hOi.setText(substring2);
    }

    public void uu(int i) {
        if (this.hOe != null) {
            if (this.status != a.hOt) {
                ap.setBackgroundColor(this.hOf, R.color.cp_bg_line_e, i);
            } else if (this.hOf != null) {
                this.hOf.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hOe.ckz())) {
                ap.setViewTextColor(this.hOg, R.color.cp_cont_d, 1, i);
            } else {
                ap.setViewTextColor(this.hOg, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.hOi, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hOj, R.color.cp_link_tip_c, 1, i);
        }
    }
}
