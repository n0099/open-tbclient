package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class BawuMemberInfoView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f14946e;

    /* renamed from: f  reason: collision with root package name */
    public View f14947f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f14948g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14949h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f14950i;
    public TextView j;
    public BawuRoleInfoPub k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BawuMemberInfoView.this.k == null) {
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            Context context = BawuMemberInfoView.this.f14946e;
            messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, "" + BawuMemberInfoView.this.k.user_id, BawuMemberInfoView.this.k.user_name)));
        }
    }

    public BawuMemberInfoView(Context context) {
        super(context);
        this.f14946e = context;
        d();
    }

    public void c(BawuRoleInfoPub bawuRoleInfoPub) {
        String str;
        if (bawuRoleInfoPub == null) {
            return;
        }
        this.k = bawuRoleInfoPub;
        BaijiahaoInfo baijiahaoInfo = bawuRoleInfoPub.baijiahao_info;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            str = bawuRoleInfoPub.baijiahao_info.avatar;
        } else {
            str = bawuRoleInfoPub.portrait;
        }
        this.f14948g.V(str, 12, false);
        this.f14949h.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
        if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(bawuRoleInfoPub.level_name);
            this.j.setVisibility(0);
        }
        int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
        if (smallGradeResourceIdNew == 0) {
            this.f14950i.setVisibility(8);
            return;
        }
        ImageView imageView = this.f14950i;
        imageView.setContentDescription(this.f14946e.getString(R.string.degree) + bawuRoleInfoPub.user_level);
        SkinManager.setImageResource(this.f14950i, smallGradeResourceIdNew);
        this.f14950i.setVisibility(0);
    }

    public void d() {
        View inflate = LayoutInflater.from(this.f14946e).inflate(R.layout.bawu_member_info_item_layout, this);
        this.f14947f = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.imageview_bawu_member);
        this.f14948g = headImageView;
        headImageView.setIsRound(true);
        this.f14948g.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f14948g.setBorderWidth(l.g(this.f14946e, R.dimen.ds1));
        this.f14947f.setOnClickListener(new a());
        this.f14950i = (ImageView) this.f14947f.findViewById(R.id.imageview_level_icon);
        this.f14949h = (TextView) this.f14947f.findViewById(R.id.textview_user_name);
        this.j = (TextView) this.f14947f.findViewById(R.id.textview_user_level);
    }

    public ImageView getLevelIcon() {
        return this.f14950i;
    }

    public TextView getLevelNameView() {
        return this.j;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.k;
    }

    public HeadImageView getPhotoView() {
        return this.f14948g;
    }

    public TextView getUserNameView() {
        return this.f14949h;
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14946e = context;
        d();
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14946e = context;
        d();
    }
}
