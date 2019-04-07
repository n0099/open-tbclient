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
    private TextView dYR;
    private HeadImageView eUn;
    private ImageView eUo;
    private TextView eUp;
    private BawuRoleInfoPub eUq;
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
        this.eUn = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.eUn.setIsRound(true);
        this.eUn.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.eUn.setBorderWidth(l.h(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.eUq != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.eUq.user_id, BawuMemberInfoView.this.eUq.user_name)));
                }
            }
        });
        this.eUo = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.dYR = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.eUp = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.eUq = bawuRoleInfoPub;
            this.eUn.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.dYR.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.eUp.setVisibility(8);
            } else {
                this.eUp.setText(bawuRoleInfoPub.level_name);
                this.eUp.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.eUo.setVisibility(8);
                return;
            }
            this.eUo.setContentDescription(this.mContext.getString(d.j.degree) + bawuRoleInfoPub.user_level);
            al.c(this.eUo, smallGradeResourceIdNew);
            this.eUo.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.eUn;
    }

    public TextView getUserNameView() {
        return this.dYR;
    }

    public ImageView getLevelIcon() {
        return this.eUo;
    }

    public TextView getLevelNameView() {
        return this.eUp;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.eUq;
    }
}
