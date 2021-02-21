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
/* loaded from: classes8.dex */
public class NewAnounceLayout extends CardBasicLayout {
    private float flf;
    private View ith;
    private TextView iti;
    private View itj;
    private TextView itk;
    private TextView itl;
    private Context mContext;
    private View.OnClickListener onClickListener;

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.segment.NewAnounceLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ar("c13447").bsO();
                if (NewAnounceLayout.this.itg != null && NewAnounceLayout.this.itg.getTid() != 0 && !TextUtils.isEmpty(NewAnounceLayout.this.itg.crk()) && NewAnounceLayout.this.itg.crm() != 2) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.mContext);
                    pbActivityConfig.createNormalCfg(NewAnounceLayout.this.itg.getTid() + "", (String) null, (String) null, true);
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
        tz();
    }

    private void tz() {
        this.ith = findViewById(R.id.announce_content);
        this.ith.setOnClickListener(this.onClickListener);
        this.iti = (TextView) findViewById(R.id.first_line_tv);
        this.itj = findViewById(R.id.second_content);
        this.itk = (TextView) findViewById(R.id.second_line_tv);
        this.itl = (TextView) findViewById(R.id.announce_tail);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.ipv == null || this.itg == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds70) * 2);
        if (this.status == a.itu) {
            this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds116) * 2);
        }
        if (this.status == a.itw) {
            this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        if (this.status == a.itv) {
            this.flf = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds86) * 2);
            this.ith.setPadding(0, 0, 0, 0);
            this.iti.setPadding(0, 0, 0, 0);
            this.itk.setPadding(0, 0, 0, 0);
            this.itl.setPadding(0, 0, 0, 0);
        }
        IL(this.itg.crk());
    }

    private void IL(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            this.itj.setVisibility(8);
            this.iti.setText(getResources().getString(R.string.empty_announce));
            return;
        }
        this.itj.setVisibility(0);
        int lineEnd = new StaticLayout(str, this.iti.getPaint(), (int) this.flf, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
        String substring = str.substring(0, lineEnd);
        if (lineEnd >= str.length()) {
            this.itj.setVisibility(8);
            this.iti.setText(substring);
            return;
        }
        String substring2 = str.substring(lineEnd, str.length());
        if (new StaticLayout(substring2, this.itk.getPaint(), (int) this.flf, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
            this.itl.setVisibility(8);
        } else {
            this.itl.setVisibility(0);
        }
        this.itj.setVisibility(0);
        this.iti.setText(substring);
        this.itk.setText(substring2);
    }

    public void uu(int i) {
        if (this.itg != null) {
            if (this.status != a.itv) {
                ap.setBackgroundColor(this.ith, R.color.CAM_X0205, i);
            } else if (this.ith != null) {
                this.ith.setBackgroundColor(0);
            }
            if (TextUtils.isEmpty(this.itg.crk())) {
                ap.setViewTextColor(this.iti, R.color.CAM_X0109, 1, i);
            } else {
                ap.setViewTextColor(this.iti, R.color.CAM_X0105, 1, i);
            }
            ap.setViewTextColor(this.itk, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.itl, R.color.CAM_X0304, 1, i);
        }
    }
}
