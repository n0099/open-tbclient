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
/* loaded from: classes3.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float cqK;
    private View.OnClickListener cze;
    private View eIl;
    private TextView eIm;
    private View eIn;
    private TextView eIo;
    private TextView eIp;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").amI();
                if (NewAnounceLayout.this.eIk != null && NewAnounceLayout.this.eIk.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.eIk.aZl())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.eIk.getTid() + "", (String) null, (String) null, true);
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
        md();
    }

    private void md() {
        this.eIl = findViewById(R.id.announce_content);
        this.eIl.setOnClickListener(this.cze);
        this.eIm = (TextView) findViewById(R.id.first_line_tv);
        this.eIn = findViewById(R.id.second_content);
        this.eIo = (TextView) findViewById(R.id.second_line_tv);
        this.eIp = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.eEy == null || this.eIk == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.cqK = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.eIz) {
            this.cqK = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.eIB) {
            this.cqK = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.eIA) {
            this.cqK = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.eIl.setPadding(0, 0, 0, 0);
            this.eIm.setPadding(0, 0, 0, 0);
            this.eIo.setPadding(0, 0, 0, 0);
            this.eIp.setPadding(0, 0, 0, 0);
        }
        ux(this.eIk.aZl());
    }

    private void ux(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.eIn.setVisibility(8);
            this.eIm.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.eIn.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.eIm.getPaint(), (int) this.cqK, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.eIn.setVisibility(8);
            this.eIm.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.eIo.getPaint(), (int) this.cqK, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.eIp.setVisibility(8);
        } else {
            this.eIp.setVisibility(0);
        }
        this.eIn.setVisibility(0);
        this.eIm.setText(substring);
        this.eIo.setText(substring2);
    }

    public void mD(int i) {
        if (this.eIk != null) {
            if (this.status != a.eIA) {
                am.setBackgroundColor(this.eIl, R.color.cp_bg_line_e, i);
            } else if (this.eIl != null) {
                this.eIl.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.eIk.aZl())) {
                am.setViewTextColor(this.eIm, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.eIm, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.eIo, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.eIp, R.color.cp_link_tip_c, 1, i);
        }
    }
}
