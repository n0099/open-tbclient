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
    private float diH;
    private View.OnClickListener drw;
    private View fGf;
    private TextView fGg;
    private View fGh;
    private TextView fGi;
    private TextView fGj;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drw = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new an("c13447").aGz();
                if (NewAnounceLayout.this.fGe != null && NewAnounceLayout.this.fGe.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.fGe.btY())) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.fGe.getTid() + "", (String) null, (String) null, true);
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
        ns();
    }

    private void ns() {
        this.fGf = findViewById(R.id.announce_content);
        this.fGf.setOnClickListener(this.drw);
        this.fGg = (TextView) findViewById(R.id.first_line_tv);
        this.fGh = findViewById(R.id.second_content);
        this.fGi = (TextView) findViewById(R.id.second_line_tv);
        this.fGj = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.fCu == null || this.fGe == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.diH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.fGt) {
            this.diH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.fGv) {
            this.diH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.fGu) {
            this.diH = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.fGf.setPadding(0, 0, 0, 0);
            this.fGg.setPadding(0, 0, 0, 0);
            this.fGi.setPadding(0, 0, 0, 0);
            this.fGj.setPadding(0, 0, 0, 0);
        }
        zR(this.fGe.btY());
    }

    private void zR(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.fGh.setVisibility(8);
            this.fGg.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.fGh.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.fGg.getPaint(), (int) this.diH, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.fGh.setVisibility(8);
            this.fGg.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.fGi.getPaint(), (int) this.diH, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.fGj.setVisibility(8);
        } else {
            this.fGj.setVisibility(0);
        }
        this.fGh.setVisibility(0);
        this.fGg.setText(substring);
        this.fGi.setText(substring2);
    }

    public void pk(int i) {
        if (this.fGe != null) {
            if (this.status != a.fGu) {
                am.setBackgroundColor(this.fGf, R.color.cp_bg_line_e, i);
            } else if (this.fGf != null) {
                this.fGf.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.fGe.btY())) {
                am.setViewTextColor(this.fGg, R.color.cp_cont_d, 1, i);
            } else {
                am.setViewTextColor(this.fGg, R.color.cp_cont_b, 1, i);
            }
            am.setViewTextColor(this.fGi, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fGj, R.color.cp_link_tip_c, 1, i);
        }
    }
}
