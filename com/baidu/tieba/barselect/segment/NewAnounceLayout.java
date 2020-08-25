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
    private View.OnClickListener eFC;
    private float euH;
    private View hfK;
    private TextView hfL;
    private View hfM;
    private TextView hfN;
    private TextView hfO;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new aq("c13447").bjn();
                if (NewAnounceLayout.this.hfJ != null && NewAnounceLayout.this.hfJ.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hfJ.caI())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hfJ.getTid() + "", (String) null, (String) null, true);
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
        this.hfK = findViewById(R.id.announce_content);
        this.hfK.setOnClickListener(this.eFC);
        this.hfL = (TextView) findViewById(R.id.first_line_tv);
        this.hfM = findViewById(R.id.second_content);
        this.hfN = (TextView) findViewById(R.id.second_line_tv);
        this.hfO = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hbV == null || this.hfJ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.euH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hfX) {
            this.euH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hfZ) {
            this.euH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hfY) {
            this.euH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hfK.setPadding(0, 0, 0, 0);
            this.hfL.setPadding(0, 0, 0, 0);
            this.hfN.setPadding(0, 0, 0, 0);
            this.hfO.setPadding(0, 0, 0, 0);
        }
        GW(this.hfJ.caI());
    }

    private void GW(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hfM.setVisibility(8);
            this.hfL.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hfM.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hfL.getPaint(), (int) this.euH, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hfM.setVisibility(8);
            this.hfL.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hfN.getPaint(), (int) this.euH, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hfO.setVisibility(8);
        } else {
            this.hfO.setVisibility(0);
        }
        this.hfM.setVisibility(0);
        this.hfL.setText(substring);
        this.hfN.setText(substring2);
    }

    public void tl(int i) {
        if (this.hfJ != null) {
            if (this.status != a.hfY) {
                ap.setBackgroundColor(this.hfK, R.color.cp_bg_line_e, i);
            } else if (this.hfK != null) {
                this.hfK.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hfJ.caI())) {
                ap.setViewTextColor(this.hfL, R.color.cp_cont_d, 1, i);
            } else {
                ap.setViewTextColor(this.hfL, R.color.cp_cont_b, 1, i);
            }
            ap.setViewTextColor(this.hfN, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hfO, R.color.cp_link_tip_c, 1, i);
        }
    }
}
