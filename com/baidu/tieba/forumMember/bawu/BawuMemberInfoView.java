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
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class BawuMemberInfoView extends RelativeLayout {
    private TextView csJ;
    private HeadImageView dig;
    private ImageView dih;
    private TextView dii;
    private BawuRoleInfoPub dij;
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
        this.dig = (HeadImageView) this.mRootView.findViewById(d.g.imageview_bawu_member);
        this.dig.setIsRound(true);
        this.dig.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.dig.setBorderWidth(l.f(this.mContext, d.e.ds1));
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.BawuMemberInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BawuMemberInfoView.this.dij != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(BawuMemberInfoView.this.mContext, "" + BawuMemberInfoView.this.dij.user_id, BawuMemberInfoView.this.dij.user_name)));
                }
            }
        });
        this.dih = (ImageView) this.mRootView.findViewById(d.g.imageview_level_icon);
        this.csJ = (TextView) this.mRootView.findViewById(d.g.textview_user_name);
        this.dii = (TextView) this.mRootView.findViewById(d.g.textview_user_level);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub) {
        if (bawuRoleInfoPub != null) {
            this.dij = bawuRoleInfoPub;
            this.dig.startLoad(bawuRoleInfoPub.portrait, 12, false);
            this.csJ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
                this.dii.setVisibility(8);
            } else {
                this.dii.setText(bawuRoleInfoPub.level_name);
                this.dii.setVisibility(0);
            }
            int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
            if (smallGradeResourceIdNew == 0) {
                this.dih.setVisibility(8);
                return;
            }
            this.dih.setContentDescription(this.mContext.getString(d.j.degree) + bawuRoleInfoPub.user_level);
            am.c(this.dih, smallGradeResourceIdNew);
            this.dih.setVisibility(0);
        }
    }

    public HeadImageView getPhotoView() {
        return this.dig;
    }

    public TextView getUserNameView() {
        return this.csJ;
    }

    public ImageView getLevelIcon() {
        return this.dih;
    }

    public TextView getLevelNameView() {
        return this.dii;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.dij;
    }
}
