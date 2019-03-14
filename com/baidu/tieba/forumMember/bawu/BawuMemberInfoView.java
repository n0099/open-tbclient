package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView dZu;
    private HeadImageView eUB;
    private ImageView eUC;
    private TextView eUD;
    private BawuRoleInfoPub eUE;
    private Context mContext;
    private View mRootView;

    public BawuMemberInfoView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.bawu_member_info_item_layout, this);
        this.eUB = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.eUB.setIsRound(true);
        this.eUB.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.eUB.setBorderWidth(l.h(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.eUE != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.eUE.user_id, BawuMemberInfoView.this.eUE.user_name)));
                }
            }
        });
        this.eUC = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.dZu = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.eUD = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.eUE = bawuRoleInfoPub;
            this.eUB.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.dZu.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.eUD.setVisibility(8);
            } else {
                this.eUD.setText(bawuRoleInfoPub.level_name);
                this.eUD.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.eUC.setVisibility(8);
                return;
            }
            this.eUC.setContentDescription(this.mContext.getString(d.j.degree) + bawuRoleInfoPub.user_level);
            al.c(this.eUC, smallGradeResourceIdNew);
            this.eUC.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.eUB;
    }

    public TextView getUserNameView() {
        return this.dZu;
    }

    public ImageView getLevelIcon() {
        return this.eUC;
    }

    public TextView getLevelNameView() {
        return this.eUD;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.eUE;
    }
}
