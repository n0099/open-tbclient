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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView cSX;
    private HeadImageView dAI;
    private ImageView dAJ;
    private TextView dAK;
    private BawuRoleInfoPub dAL;
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
        this.dAI = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.dAI.setIsRound(true);
        this.dAI.setBorderColor(aj.getColor(d.C0140d.common_color_10043));
        this.dAI.setBorderWidth(l.t(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.dAL != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.dAL.user_id, BawuMemberInfoView.this.dAL.user_name)));
                }
            }
        });
        this.dAJ = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.cSX = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.dAK = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.dAL = bawuRoleInfoPub;
            this.dAI.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.cSX.setText(bawuRoleInfoPub.user_name);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.dAK.setVisibility(8);
            } else {
                this.dAK.setText(bawuRoleInfoPub.level_name);
                this.dAK.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.dAJ.setVisibility(8);
                return;
            }
            this.dAJ.setContentDescription(this.mContext.getString(d.j.degree) + bawuRoleInfoPub.user_level);
            aj.c(this.dAJ, smallGradeResourceIdNew);
            this.dAJ.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.dAI;
    }

    public TextView getUserNameView() {
        return this.cSX;
    }

    public ImageView getLevelIcon() {
        return this.dAJ;
    }

    public TextView getLevelNameView() {
        return this.dAK;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.dAL;
    }
}
