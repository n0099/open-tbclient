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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView csG;
    private HeadImageView die;
    private ImageView dif;
    private TextView dig;
    private BawuRoleInfoPub dih;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.bawu_member_info_item_layout, this);
        this.die = (HeadImageView) this.mRootView.findViewById(f.g.imageview_bawu_member);
        this.die.setIsRound(true);
        this.die.setBorderColor(am.getColor(f.d.common_color_10043));
        this.die.setBorderWidth(l.f(this.mContext, f.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.dih != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.dih.user_id, BawuMemberInfoView.this.dih.user_name)));
                }
            }
        });
        this.dif = (ImageView) this.mRootView.findViewById(f.g.imageview_level_icon);
        this.csG = (TextView) this.mRootView.findViewById(f.g.textview_user_name);
        this.dig = (TextView) this.mRootView.findViewById(f.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.dih = bawuRoleInfoPub;
            this.die.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.csG.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.dig.setVisibility(8);
            } else {
                this.dig.setText(bawuRoleInfoPub.level_name);
                this.dig.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.dif.setVisibility(8);
                return;
            }
            this.dif.setContentDescription(this.mContext.getString(f.j.degree) + bawuRoleInfoPub.user_level);
            am.c(this.dif, smallGradeResourceIdNew);
            this.dif.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.die;
    }

    public TextView getUserNameView() {
        return this.csG;
    }

    public ImageView getLevelIcon() {
        return this.dif;
    }

    public TextView getLevelNameView() {
        return this.dig;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.dih;
    }
}
