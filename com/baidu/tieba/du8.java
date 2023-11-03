package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class du8 extends fu8<GroupInfoData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du8(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.yt8
    public void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            GroupInfoData groupInfoData = (GroupInfoData) this.j;
            long userIdLong = this.k.getUserIdLong();
            String userName = this.k.getUserName();
            String name_show = this.k.getName_show();
            String portrait = this.k.getPortrait();
            if (this.k.getIsMyFriend() == 1) {
                z = true;
            } else {
                z = false;
            }
            nw8.b(groupInfoData, str, userIdLong, userName, name_show, portrait, z);
            if (GroupInfoData.isValidGroup((GroupInfoData) this.j)) {
                bw8.c((GroupInfoData) this.j, this.k, 1);
            }
        }
    }

    @Override // com.baidu.tieba.yt8
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            nw8.i(str, this.k.groupData, (GroupInfoData) this.j);
        }
    }

    @Override // com.baidu.tieba.fu8
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.g();
            EMManager.from(this.m).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            EMManager.from(this.p).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.q).setTextColor(R.color.CAM_X0109);
            this.n.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    @Override // com.baidu.tieba.fu8
    public void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            super.m(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.im_share_dialog_group, i());
            this.m = (LinearLayout) inflate.findViewById(R.id.im_share_group_info_container);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.im_share_group_info_head);
            this.n = barImageView;
            barImageView.setPlaceHolder(1);
            this.n.setAutoChangeStyle(true);
            this.n.setShowInnerBorder(true);
            this.n.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01));
            this.n.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.n.setRadiusById(R.string.J_X04);
            this.o = (TextView) inflate.findViewById(R.id.im_share_group_info_name);
            this.p = (TextView) inflate.findViewById(R.id.im_share_group_info_forum_name);
            this.q = (TextView) inflate.findViewById(R.id.im_share_group_info_member_count);
            g();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fu8
    /* renamed from: q */
    public void o(GroupInfoData groupInfoData, MetaData metaData) {
        String forumName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, groupInfoData, metaData) == null) {
            super.o(groupInfoData, metaData);
            if (groupInfoData == null) {
                return;
            }
            this.n.startLoad(groupInfoData.getPortrait(), 10, false);
            this.o.setText(groupInfoData.getName());
            if (!TextUtils.isEmpty(groupInfoData.getDesc())) {
                this.p.setText(groupInfoData.getDesc());
                return;
            }
            TextView textView = this.p;
            if (!TextUtils.isEmpty(groupInfoData.getForumShowName())) {
                forumName = groupInfoData.getForumShowName();
            } else {
                forumName = groupInfoData.getForumName();
            }
            textView.setText(forumName);
            if (groupInfoData.getMemberNum() > 0) {
                this.q.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.group_member_share_slogan), StringHelper.numFormatOverWan(groupInfoData.getMemberNum())));
            } else {
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.group_share_slogan_default));
            }
        }
    }
}
