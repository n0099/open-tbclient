package com.baidu.tieba.im.sendcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GamePlaySendCardMsgData;
import com.baidu.tieba.tbadkCore.voice.VoicePlayBtn;
import com.baidu.tieba.ve5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import tbclient.Voice;
/* loaded from: classes6.dex */
public class GamePlaySendCardMsgView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext b;
    public ImageView c;
    public EMTextView d;
    public RelativeLayout e;
    public VoicePlayBtn f;
    public RelativeLayout g;
    public TbImageView h;
    public EMTextView i;
    public ImageView j;
    public LinearLayout k;
    public EMTextView l;
    public View m;
    public EMTextView n;
    public RelativeLayout o;
    public EMTextView p;
    public GamePlaySendCardMsgData q;
    public String r;
    public String s;
    public boolean t;
    public ve5 u;
    public CustomMessageListener v;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlaySendCardMsgView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GamePlaySendCardMsgView gamePlaySendCardMsgView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlaySendCardMsgView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlaySendCardMsgView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.UpdateAttentionData data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.isSucc) {
                this.a.b.showToast(updateAttentionMessage.getData().errorString);
                return;
            }
            this.a.b.showToast(R.string.attention_success);
            this.a.t = true;
            this.a.o();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlaySendCardMsgView a;

        public b(GamePlaySendCardMsgView gamePlaySendCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlaySendCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlaySendCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.t && !StringUtils.isNull(this.a.q.getFollow().getPersonal_home_page())) {
                    UrlSchemaJumpHelper.jumpGameGodsPage(this.a.getContext(), this.a.q.getFollow().getPersonal_home_page());
                    str = CommonStatisticKey.KEY_HOME_PAGE_CLICK;
                } else {
                    this.a.m();
                    str = CommonStatisticKey.KEY_ATTENTION_CLICK;
                }
                TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.a.s));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements VoicePlayBtn.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlaySendCardMsgView a;

        public c(GamePlaySendCardMsgView gamePlaySendCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlaySendCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlaySendCardMsgView;
        }

        @Override // com.baidu.tieba.tbadkCore.voice.VoicePlayBtn.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_PLAY_VOICE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.a.s));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GamePlaySendCardMsgView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamePlaySendCardMsgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.t = false;
        a aVar = new a(this, 2001115);
        this.v = aVar;
        aVar.setSelfListener(true);
        this.v.setTag(this.a);
        MessageManager.getInstance().registerListener(this.v);
        j();
        i();
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAttention(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.t = z;
            o();
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && !k(str)) {
            h();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ve5 ve5Var = this.u;
            if (ve5Var != null) {
                ve5Var.e();
            }
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    public final void h() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (relativeLayout = this.o) != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = this.o;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new b(this));
            }
            VoicePlayBtn voicePlayBtn = this.f;
            if (voicePlayBtn != null) {
                voicePlayBtn.setMClickCallBack(new c(this));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            g();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.msg_game_play_send_card_view, this);
            setOrientation(1);
            this.c = (ImageView) findViewById(R.id.msg_send_card_bg);
            this.d = (EMTextView) findViewById(R.id.msg_send_card_title);
            this.e = (RelativeLayout) findViewById(R.id.msg_send_card_rl_voice);
            this.g = (RelativeLayout) findViewById(R.id.msg_send_card_content);
            this.h = (TbImageView) findViewById(R.id.msg_send_card_avatar);
            this.i = (EMTextView) findViewById(R.id.msg_send_card_name);
            this.j = (ImageView) findViewById(R.id.msg_send_card_sex);
            this.k = (LinearLayout) findViewById(R.id.msg_send_card_tags);
            this.l = (EMTextView) findViewById(R.id.msg_send_card_good_rate);
            this.m = findViewById(R.id.msg_send_card_line);
            this.n = (EMTextView) findViewById(R.id.msg_send_card_order_num);
            this.o = (RelativeLayout) findViewById(R.id.msg_send_card_btn);
            this.p = (EMTextView) findViewById(R.id.msg_send_card_btn_text);
            this.f = new VoicePlayBtn(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006);
            layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004);
            this.e.addView(this.f, layoutParams);
            Glide.with(getContext()).load(Integer.valueOf((int) R.drawable.im_game_bg)).placeholder((int) R.drawable.pic_use_header_40_n).apply((BaseRequestOptions<?>) new RequestOptions().transform(new RoundedCorners(25))).into(this.c);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                SkinManager.setBackgroundResource(this, R.drawable.icon_pic_im_bubble_share_left);
            } else if (!StringUtils.isNull(str) && str.endsWith("MsgrightView")) {
                SkinManager.setBackgroundResource(this, R.drawable.icon_pic_im_bubble_share_right);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.c.setVisibility(8);
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            EMManager.from(this.m).setBackGroundColor(R.color.CAM_X0625);
            EMManager.from(this.g).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            n();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.b.showToast(R.string.no_network);
                return;
            }
            if (this.u == null) {
                this.u = new ve5(this.b);
            }
            this.u.h(true, this.r, this.s, this.a);
        }
    }

    public final void n() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMTextView eMTextView = this.p;
            if (this.t) {
                i = R.color.CAM_X0105;
            } else {
                i = R.color.CAM_X0101;
            }
            SkinManager.setViewTextColor(eMTextView, i);
            if (this.t) {
                EMManager.from(this.o).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0625).setBackGroundColor(0);
            } else {
                EMManager.from(this.o).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0341);
            }
        }
    }

    public final void o() {
        GamePlaySendCardMsgData gamePlaySendCardMsgData;
        String intro_txt;
        String btn_txt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (gamePlaySendCardMsgData = this.q) == null) {
            return;
        }
        EMTextView eMTextView = this.d;
        if (this.t) {
            intro_txt = gamePlaySendCardMsgData.getFollow().getIntro_txt();
        } else {
            intro_txt = gamePlaySendCardMsgData.getIntro_txt();
        }
        eMTextView.setText(intro_txt);
        EMTextView eMTextView2 = this.p;
        if (this.t) {
            btn_txt = this.q.getFollow().getBtn_txt();
        } else {
            btn_txt = this.q.getBtn_txt();
        }
        eMTextView2.setText(btn_txt);
        n();
    }

    public final void p() {
        String intro_txt;
        String btn_txt;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.setVisibility(0);
            EMTextView eMTextView = this.d;
            if (this.t) {
                intro_txt = this.q.getFollow().getIntro_txt();
            } else {
                intro_txt = this.q.getIntro_txt();
            }
            eMTextView.setText(intro_txt);
            Glide.with(getContext()).load(this.q.getAvatar()).placeholder((int) R.drawable.pic_use_header_40_n).apply((BaseRequestOptions<?>) new RequestOptions().transform(new CenterCrop(), new RoundedCorners(21))).into(this.h);
            this.i.setText(this.q.getNickname());
            this.i.setMaxWidth((((BdUtilHelper.getDimens(getContext(), R.dimen.tbds762) - (BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006) * 4)) - BdUtilHelper.getDimens(getContext(), R.dimen.tbds132)) - BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004)) - BdUtilHelper.getDimens(getContext(), R.dimen.tbds39));
            Voice.Builder builder = new Voice.Builder();
            builder.voice_url = this.q.getAudio_url();
            builder.during_time = Integer.valueOf(this.q.getDuration());
            this.f.setData(builder.build(false));
            if (this.q.getOrder_num() == 0) {
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.l.setText(R.string.im_msg_send_card_good_rate_num);
            } else {
                this.m.setVisibility(0);
                this.l.setText(getResources().getString(R.string.im_msg_send_card_good_rate, Integer.valueOf(this.q.getGood_rate())));
                this.n.setText(getResources().getString(R.string.im_msg_send_card_order_num, Integer.valueOf(this.q.getOrder_num())));
            }
            if (this.q.getSex() != null) {
                ImageView imageView = this.j;
                if (AccountConstants.FEMALE_TEXT.equals(this.q.getSex())) {
                    i = R.drawable.icon_send_card_girl;
                } else {
                    i = R.drawable.icon_send_card_boy;
                }
                imageView.setImageResource(i);
            }
            if (ListUtils.isEmpty(this.q.getTags())) {
                return;
            }
            int dimens = (BdUtilHelper.getDimens(getContext(), R.dimen.tbds762) - (BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006) * 4)) - BdUtilHelper.getDimens(getContext(), R.dimen.tbds132);
            for (int i2 = 0; i2 < this.q.getTags().size(); i2++) {
                GamePlaySendCardMsgData.SendCardTagInfo sendCardTagInfo = this.q.getTags().get(i2);
                if (!StringUtils.isNull(sendCardTagInfo.getTag_img())) {
                    int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds195);
                    if (dimens < dimens2) {
                        return;
                    }
                    TbImageView tbImageView = new TbImageView(getContext());
                    tbImageView.setPlaceHolderAutoChangeSkinType(2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds195), BdUtilHelper.getDimens(getContext(), R.dimen.tbds48));
                    layoutParams.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
                    tbImageView.setLayoutParams(layoutParams);
                    Glide.with(getContext()).load(sendCardTagInfo.getTag_img()).placeholder((int) R.drawable.pic_use_header_40_n).into(tbImageView);
                    this.k.addView(tbImageView);
                    dimens -= dimens2;
                } else {
                    EMTextView eMTextView2 = new EMTextView(getContext());
                    float measureText = eMTextView2.getPaint().measureText(sendCardTagInfo.getTag_name());
                    if (dimens < measureText) {
                        return;
                    }
                    eMTextView2.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), BdUtilHelper.getDimens(getContext(), R.dimen.tbds3), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), BdUtilHelper.getDimens(getContext(), R.dimen.tbds9));
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
                    eMTextView2.setLayoutParams(layoutParams2);
                    eMTextView2.setText(sendCardTagInfo.getTag_name());
                    eMTextView2.setGravity(16);
                    EMManager.from(eMTextView2).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0302).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0905);
                    this.k.addView(eMTextView2);
                    dimens -= Math.round(measureText);
                }
            }
            EMTextView eMTextView3 = this.p;
            if (this.t) {
                btn_txt = this.q.getFollow().getBtn_txt();
            } else {
                btn_txt = this.q.getBtn_txt();
            }
            eMTextView3.setText(btn_txt);
            l("");
        }
    }

    public void setData(GamePlaySendCardMsgData gamePlaySendCardMsgData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048588, this, gamePlaySendCardMsgData, str, str2) != null) || this.q != null) {
            return;
        }
        this.q = gamePlaySendCardMsgData;
        this.r = str;
        this.s = str2;
        if (gamePlaySendCardMsgData != null) {
            p();
        }
    }
}
