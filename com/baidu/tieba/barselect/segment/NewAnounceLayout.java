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
/* loaded from: classes20.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float eWr;
    private View.OnClickListener fhp;
    private View hUC;
    private TextView hUD;
    private View hUE;
    private TextView hUF;
    private TextView hUG;
    private Context mContext;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ar("c13447").bqy();
                if (NewAnounceLayout.this.hUB != null && NewAnounceLayout.this.hUB.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.hUB.cmD()) && NewAnounceLayout.this.hUB.cmF() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.hUB.getTid() + "", (String) null, (String) null, true);
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
        this.hUC = findViewById(R.id.announce_content);
        this.hUC.setOnClickListener(this.fhp);
        this.hUD = (TextView) findViewById(R.id.first_line_tv);
        this.hUE = findViewById(R.id.second_content);
        this.hUF = (TextView) findViewById(R.id.second_line_tv);
        this.hUG = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.hQM == null || this.hUB == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.eWr = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.hUP) {
            this.eWr = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.hUR) {
            this.eWr = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.hUQ) {
            this.eWr = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.hUC.setPadding(0, 0, 0, 0);
            this.hUD.setPadding(0, 0, 0, 0);
            this.hUF.setPadding(0, 0, 0, 0);
            this.hUG.setPadding(0, 0, 0, 0);
        }
        Iy(this.hUB.cmD());
    }

    private void Iy(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.hUE.setVisibility(8);
            this.hUD.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.hUE.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.hUD.getPaint(), (int) this.eWr, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.hUE.setVisibility(8);
            this.hUD.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.hUF.getPaint(), (int) this.eWr, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.hUG.setVisibility(8);
        } else {
            this.hUG.setVisibility(0);
        }
        this.hUE.setVisibility(0);
        this.hUD.setText(substring);
        this.hUF.setText(substring2);
    }

    public void vc(int i) {
        if (this.hUB != null) {
            if (this.status != a.hUQ) {
                ap.setBackgroundColor(this.hUC, R.color.CAM_X0205, i);
            } else if (this.hUC != null) {
                this.hUC.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.hUB.cmD())) {
                ap.setViewTextColor(this.hUD, R.color.CAM_X0109, 1, i);
            } else {
                ap.setViewTextColor(this.hUD, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.hUF, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.hUG, R.color.CAM_X0304, 1, i);
        }
    }
}
