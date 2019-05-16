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
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView ejr;
    private TextView fkA;
    private BawuRoleInfoPub fkB;
    private HeadImageView fky;
    private ImageView fkz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bawu_member_info_item_layout, this);
        this.fky = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.fky.setIsRound(true);
        this.fky.setBorderColor(al.getColor(R.color.common_color_10043));
        this.fky.setBorderWidth(l.g(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.fkB != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.fkB.user_id, BawuMemberInfoView.this.fkB.user_name)));
                }
            }
        });
        this.fkz = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.ejr = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.fkA = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.fkB = bawuRoleInfoPub;
            this.fky.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.ejr.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.fkA.setVisibility(8);
            } else {
                this.fkA.setText(bawuRoleInfoPub.level_name);
                this.fkA.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.fkz.setVisibility(8);
                return;
            }
            this.fkz.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            al.c(this.fkz, smallGradeResourceIdNew);
            this.fkz.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.fky;
    }

    public TextView getUserNameView() {
        return this.ejr;
    }

    public ImageView getLevelIcon() {
        return this.fkz;
    }

    public TextView getLevelNameView() {
        return this.fkA;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.fkB;
    }
}
