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
    private TextView ejs;
    private ImageView fkA;
    private TextView fkB;
    private BawuRoleInfoPub fkC;
    private HeadImageView fkz;
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
        this.fkz = (HeadImageView) this.mRootView.findViewById(R.id.imageview_bawu_member);
        this.fkz.setIsRound(true);
        this.fkz.setBorderColor(al.getColor(R.color.common_color_10043));
        this.fkz.setBorderWidth(l.g(this.mContext, R.dimen.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.fkC != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.fkC.user_id, BawuMemberInfoView.this.fkC.user_name)));
                }
            }
        });
        this.fkA = (ImageView) this.mRootView.findViewById(R.id.imageview_level_icon);
        this.ejs = (TextView) this.mRootView.findViewById(R.id.textview_user_name);
        this.fkB = (TextView) this.mRootView.findViewById(R.id.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.fkC = bawuRoleInfoPub;
            this.fkz.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.ejs.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.fkB.setVisibility(8);
            } else {
                this.fkB.setText(bawuRoleInfoPub.level_name);
                this.fkB.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.fkA.setVisibility(8);
                return;
            }
            this.fkA.setContentDescription(this.mContext.getString(R.string.degree) + bawuRoleInfoPub.user_level);
            al.c(this.fkA, smallGradeResourceIdNew);
            this.fkA.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.fkz;
    }

    public TextView getUserNameView() {
        return this.ejs;
    }

    public ImageView getLevelIcon() {
        return this.fkA;
    }

    public TextView getLevelNameView() {
        return this.fkB;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.fkC;
    }
}
