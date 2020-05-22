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
    private float dXg;
    private View.OnClickListener ege;
    private View gAo;
    private TextView gAp;
    private View gAq;
    private TextView gAr;
    private TextView gAs;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aUS();
                if (NewAnounceLayout.this.gAn != null && NewAnounceLayout.this.gAn.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.gAn.bKe())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.gAn.getTid() + "", (String) null, (String) null, true);
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
        rV();
    }

    private void rV() {
        this.gAo = findViewById(R.id.announce_content);
        this.gAo.setOnClickListener(this.ege);
        this.gAp = (TextView) findViewById(R.id.first_line_tv);
        this.gAq = findViewById(R.id.second_content);
        this.gAr = (TextView) findViewById(R.id.second_line_tv);
        this.gAs = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.gwA == null || this.gAn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.gAC) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.gAE) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.gAD) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.gAo.setPadding(0, 0, 0, 0);
            this.gAp.setPadding(0, 0, 0, 0);
            this.gAr.setPadding(0, 0, 0, 0);
            this.gAs.setPadding(0, 0, 0, 0);
        }
        Dl(this.gAn.bKe());
    }

    private void Dl(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.gAq.setVisibility(8);
            this.gAp.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.gAq.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.gAp.getPaint(), (int) this.dXg, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.gAq.setVisibility(8);
            this.gAp.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.gAr.getPaint(), (int) this.dXg, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.gAs.setVisibility(8);
        } else {
            this.gAs.setVisibility(0);
        }
        this.gAq.setVisibility(0);
        this.gAp.setText(substring);
        this.gAr.setText(substring2);
    }

    public void qi(int i) {
        if (this.gAn != null) {
            if (this.status != a.gAD) {
                am.setBackgroundColor(this.gAo, R.color.cp_bg_line_e, i);
            } else if (this.gAo != null) {
                this.gAo.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.gAn.bKe())) {
                am.setViewTextColor(this.gAp, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.gAp, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.gAr, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.gAs, R.color.cp_link_tip_c, 1, i);
        }
    }
}
