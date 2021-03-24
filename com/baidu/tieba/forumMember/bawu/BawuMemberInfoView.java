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
import d.b.b.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class BawuMemberInfoView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f15897e;

    /* renamed from: f  reason: collision with root package name */
    public View f15898f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15899g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15900h;
    public ImageView i;
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
            Context context = BawuMemberInfoView.this.f15897e;
            messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, "" + BawuMemberInfoView.this.k.user_id, BawuMemberInfoView.this.k.user_name)));
        }
    }

    public BawuMemberInfoView(Context context) {
        super(context);
        this.f15897e = context;
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
        this.f15899g.W(str, 12, false);
        this.f15900h.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
        if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(bawuRoleInfoPub.level_name);
            this.j.setVisibility(0);
        }
        int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
        if (smallGradeResourceIdNew == 0) {
            this.i.setVisibility(8);
            return;
        }
        ImageView imageView = this.i;
        imageView.setContentDescription(this.f15897e.getString(R.string.degree) + bawuRoleInfoPub.user_level);
        SkinManager.setImageResource(this.i, smallGradeResourceIdNew);
        this.i.setVisibility(0);
    }

    public void d() {
        View inflate = LayoutInflater.from(this.f15897e).inflate(R.layout.bawu_member_info_item_layout, this);
        this.f15898f = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.imageview_bawu_member);
        this.f15899g = headImageView;
        headImageView.setIsRound(true);
        this.f15899g.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f15899g.setBorderWidth(l.g(this.f15897e, R.dimen.ds1));
        this.f15898f.setOnClickListener(new a());
        this.i = (ImageView) this.f15898f.findViewById(R.id.imageview_level_icon);
        this.f15900h = (TextView) this.f15898f.findViewById(R.id.textview_user_name);
        this.j = (TextView) this.f15898f.findViewById(R.id.textview_user_level);
    }

    public ImageView getLevelIcon() {
        return this.i;
    }

    public TextView getLevelNameView() {
        return this.j;
    }

    public BawuRoleInfoPub getMemberData() {
        return this.k;
    }

    public HeadImageView getPhotoView() {
        return this.f15899g;
    }

    public TextView getUserNameView() {
        return this.f15900h;
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15897e = context;
        d();
    }

    public BawuMemberInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15897e = context;
        d();
    }
}
