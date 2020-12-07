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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes21.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float fdO;
    private View.OnClickListener foP;
    private TextView ifA;
    private View ifB;
    private TextView ifC;
    private TextView ifD;
    private View ifz;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ar("c13447").btT();
                if (NewAnounceLayout.this.ify != null && NewAnounceLayout.this.ify.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.ify.cqQ()) && NewAnounceLayout.this.ify.cqS() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.ify.getTid() + "", (String) null, (String) null, true);
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
        uo();
    }

    private void uo() {
        this.ifz = findViewById(R.id.announce_content);
        this.ifz.setOnClickListener(this.foP);
        this.ifA = (TextView) findViewById(R.id.first_line_tv);
        this.ifB = findViewById(R.id.second_content);
        this.ifC = (TextView) findViewById(R.id.second_line_tv);
        this.ifD = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ibG == null || this.ify == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.fdO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.ifM) {
            this.fdO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.ifO) {
            this.fdO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.ifN) {
            this.fdO = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.ifz.setPadding(0, 0, 0, 0);
            this.ifA.setPadding(0, 0, 0, 0);
            this.ifC.setPadding(0, 0, 0, 0);
            this.ifD.setPadding(0, 0, 0, 0);
        }
        Jo(this.ify.cqQ());
    }

    private void Jo(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.ifB.setVisibility(8);
            this.ifA.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.ifB.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.ifA.getPaint(), (int) this.fdO, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.ifB.setVisibility(8);
            this.ifA.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.ifC.getPaint(), (int) this.fdO, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.ifD.setVisibility(8);
        } else {
            this.ifD.setVisibility(0);
        }
        this.ifB.setVisibility(0);
        this.ifA.setText(substring);
        this.ifC.setText(substring2);
    }

    public void vJ(int i) {
        if (this.ify != null) {
            if (this.status != a.ifN) {
                ap.setBackgroundColor(this.ifz, R.color.CAM_X0205, i);
            } else if (this.ifz != null) {
                this.ifz.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.ify.cqQ())) {
                ap.setViewTextColor(this.ifA, R.color.CAM_X0109, 1, i);
            } else {
                ap.setViewTextColor(this.ifA, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.ifC, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.ifD, R.color.CAM_X0304, 1, i);
        }
    }
}
