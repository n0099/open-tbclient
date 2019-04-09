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
    private TextView dYS;
    private HeadImageView eUo;
    private ImageView eUp;
    private TextView eUq;
    private BawuRoleInfoPub eUr;
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
        this.eUo = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.eUo.setIsRound(true);
        this.eUo.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.eUo.setBorderWidth(l.h(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.eUr != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.eUr.user_id, BawuMemberInfoView.this.eUr.user_name)));
                }
            }
        });
        this.eUp = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.dYS = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.eUq = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.eUr = bawuRoleInfoPub;
            this.eUo.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.dYS.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.eUq.setVisibility(8);
            } else {
                this.eUq.setText(bawuRoleInfoPub.level_name);
                this.eUq.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.eUp.setVisibility(8);
                return;
            }
            this.eUp.setContentDescription(this.mContext.getString(d.j.degree) + bawuRoleInfoPub.user_level);
            al.c(this.eUp, smallGradeResourceIdNew);
            this.eUp.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.eUo;
    }

    public TextView getUserNameView() {
        return this.dYS;
    }

    public ImageView getLevelIcon() {
        return this.eUp;
    }

    public TextView getLevelNameView() {
        return this.eUq;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.eUr;
    }
}
