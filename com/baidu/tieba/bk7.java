package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.bk7;
import com.baidu.tieba.fn6;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public abstract class bk7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<ImMessageCenterShowItemData> b;
    public boolean c;
    public boolean d;

    public abstract boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    public abstract void j(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract void u(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract BasicNameValuePair x(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public HeadImageView b;
        public ImageView c;
        public BarImageView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public MessageRedDotView h;
        public FrameLayout i;
        public View j;
        public LinearLayout k;
        public ImageView l;
        public ImageView m;
        public ImageView n;

        public a(bk7 bk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
        }
    }

    public bk7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.a = context;
    }

    public void k(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, aVar, imMessageCenterShowItemData) == null) {
            if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0206, R.color.CAM_X0204);
            } else {
                TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public void l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, aVar, imMessageCenterShowItemData) == null) {
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                aVar.f.setText("");
                aVar.f.setVisibility(8);
                aVar.i.setVisibility(8);
                return;
            }
            h(imMessageCenterShowItemData, aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<ImMessageCenterShowItemData> list = this.b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.b.get(i);
        }
        return (ImMessageCenterShowItemData) invokeI.objValue;
    }

    public final boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null || !String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void t(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.c = z;
        }
    }

    public a b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            a aVar = new a(this);
            aVar.a = (ViewGroup) view2.findViewById(R.id.chat_item);
            aVar.c = (ImageView) view2.findViewById(R.id.svg_head);
            aVar.b = (HeadImageView) view2.findViewById(R.id.chat_head);
            aVar.d = (BarImageView) view2.findViewById(R.id.forum_head);
            aVar.e = (TextView) view2.findViewById(R.id.chat_name);
            aVar.f = (TextView) view2.findViewById(R.id.last_chat_content);
            aVar.g = (TextView) view2.findViewById(R.id.chat_time);
            aVar.j = view2.findViewById(R.id.obfuscated_res_0x7f0913eb);
            aVar.h = (MessageRedDotView) view2.findViewById(R.id.new_message);
            aVar.i = (FrameLayout) view2.findViewById(R.id.new_message_container);
            aVar.h.setShadowEnabled(false);
            aVar.k = (LinearLayout) view2.findViewById(R.id.my_fans);
            aVar.l = (ImageView) view2.findViewById(R.id.send_status);
            aVar.m = (ImageView) view2.findViewById(R.id.select_status);
            aVar.n = (ImageView) view2.findViewById(R.id.chat_group_logo);
            aVar.b.setPlaceHolder(1);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<ImMessageCenterShowItemData> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                aVar = null;
            }
            if (aVar == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.chat_list_item, viewGroup, false);
                aVar = b(view2);
                view2.setTag(aVar);
            }
            SkinManager.setBackgroundResource(view2, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(aVar.j, R.color.CAM_X0205);
            aVar.a.setVisibility(0);
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                n(aVar, item);
                l(aVar, item);
                p(aVar, item);
                q(aVar, item);
                j(aVar, item);
                r(aVar, item);
                u(aVar, item);
                if (this.d) {
                    m(aVar, item);
                }
                i(aVar, item);
                o(aVar, item);
                k(aVar, item);
                y(item);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(ImMessageCenterShowItemData imMessageCenterShowItemData, final a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, imMessageCenterShowItemData, aVar) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (d(imMessageCenterShowItemData)) {
                if (imMessageCenterShowItemData.getAtInfoData() != null && imMessageCenterShowItemData.getAtInfoData().a() > 0) {
                    SpannableString spannableString = new SpannableString("[有人@我]");
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, 6, 33);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) imMessageCenterShowItemData.getMsgContent());
                } else if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    String valueOf = String.valueOf(imMessageCenterShowItemData.getUnReadCount());
                    if (imMessageCenterShowItemData.getUnReadCount() >= 100) {
                        spannableStringBuilder.append((CharSequence) ("[99+]" + imMessageCenterShowItemData.getMsgContent()));
                    } else {
                        spannableStringBuilder.append((CharSequence) (PreferencesUtil.LEFT_MOUNT + valueOf + "条]" + imMessageCenterShowItemData.getMsgContent()));
                    }
                } else {
                    spannableStringBuilder.append((CharSequence) imMessageCenterShowItemData.getMsgContent());
                }
            } else {
                spannableStringBuilder.append((CharSequence) imMessageCenterShowItemData.getMsgContent());
            }
            aVar.f.setVisibility(0);
            aVar.i.setVisibility(0);
            fn6.f(aVar.f.getContext(), spannableStringBuilder, new fn6.i() { // from class: com.baidu.tieba.yj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.fn6.i
                public final void a(SpannableStringBuilder spannableStringBuilder2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder2) == null) {
                        bk7.a.this.f.setText(spannableStringBuilder2);
                    }
                }
            });
        }
    }

    public void r(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, aVar, imMessageCenterShowItemData) == null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            if (d(imMessageCenterShowItemData)) {
                unReadCount = 0;
            }
            if (unReadCount > 0) {
                if (m85.d().f() == 0) {
                    unReadCount = 0;
                } else {
                    BasicNameValuePair x = x(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                    if (x != null && x.getName() != null && x.getName().length() > 0) {
                        unReadCount = dh.e(x.getName(), 0);
                    }
                }
                aVar.h.setThreeDotMode(2);
                aVar.h.f(unReadCount);
                aVar.h.setVisibility(0);
            } else if (d(imMessageCenterShowItemData) && imMessageCenterShowItemData.isNotify && imMessageCenterShowItemData.getUnReadCount() > 0) {
                aVar.h.setThreeDotMode(2);
                aVar.h.f(unReadCount);
                aVar.h.setVisibility(0);
            } else {
                aVar.h.setVisibility(8);
            }
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.g, R.color.CAM_X0110, 1);
        }
    }

    public void i(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, aVar, imMessageCenterShowItemData) != null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData == null) {
            s(false, aVar);
        } else if (f(imMessageCenterShowItemData)) {
            if (d(imMessageCenterShowItemData)) {
                if (!imMessageCenterShowItemData.isNotify()) {
                    s(true, aVar);
                    return;
                } else {
                    s(false, aVar);
                    return;
                }
            }
            ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
            if (groupSetting == null) {
                s(false, aVar);
            } else if (!groupSetting.isAcceptNotify()) {
                s(true, aVar);
            } else {
                s(false, aVar);
            }
        } else {
            s(false, aVar);
        }
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, aVar, imMessageCenterShowItemData) != null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getRelation() == 3) {
            aVar.k.setVisibility(0);
            p15 d = p15.d(aVar.k);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0202);
            SkinManager.setViewTextColor((TextView) aVar.k.findViewById(R.id.my_fans_title), (int) R.color.CAM_X0108);
            return;
        }
        aVar.k.setVisibility(8);
    }

    public void p(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, aVar, imMessageCenterShowItemData) == null) && aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (g(imMessageCenterShowItemData)) {
                aVar.l.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    SkinManager.setBackgroundResource(aVar.l, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    SkinManager.setBackgroundResource(aVar.l, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.l.setVisibility(8);
                    return;
                }
            }
            aVar.l.setVisibility(8);
        }
    }

    public final void s(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048597, this, z, aVar) == null) {
            if (z) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                pureDrawable.setBounds(new Rect(0, ej.g(this.a, R.dimen.tbds9), ej.g(this.a, R.dimen.tbds34), ej.g(this.a, R.dimen.tbds43)));
                aVar.f.setCompoundDrawables(null, null, pureDrawable, null);
                return;
            }
            aVar.f.setCompoundDrawables(null, null, null, null);
        }
    }

    public void n(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        if (d(imMessageCenterShowItemData) && !TextUtils.isEmpty(imMessageCenterShowItemData.getForumName())) {
            String forumName = imMessageCenterShowItemData.getForumName();
            String friendNameShow = imMessageCenterShowItemData.getFriendNameShow();
            if (forumName.length() > 8) {
                forumName = forumName.substring(0, 7) + StringHelper.STRING_MORE;
            }
            w(aVar, forumName + "吧", forumName + "吧 | " + friendNameShow);
            return;
        }
        aVar.e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    public void o(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, aVar, imMessageCenterShowItemData) == null) {
            if (this.c) {
                aVar.m.setVisibility(0);
                aVar.g.setVisibility(8);
                if (imMessageCenterShowItemData.isSelected()) {
                    aVar.m.setBackgroundResource(R.drawable.btn_bgb_choice_s_new);
                    WebPManager.setPureDrawable(aVar.m, R.drawable.btn_bgb_choice_s_new, R.color.CAM_X0302, null);
                } else {
                    aVar.m.setBackgroundResource(R.drawable.btn_bgb_choice_n_new);
                    WebPManager.setPureDrawable(aVar.m, R.drawable.btn_bgb_choice_n_new, R.color.CAM_X0111, null);
                }
                SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                return;
            }
            aVar.m.setVisibility(8);
            aVar.g.setVisibility(0);
            TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void q(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, aVar, imMessageCenterShowItemData) == null) && aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = StringHelper.getChatTimeString(date);
            } else {
                str = "";
            }
            aVar.g.setText(str);
        }
    }

    public void w(a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048601, this, aVar, str, str2) == null) && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int indexOf = str2.indexOf(str);
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), indexOf, str.length() + indexOf, 33);
            aVar.e.setText(spannableString);
        }
    }

    public final void y(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, imMessageCenterShowItemData) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        int i = 0;
        int i2 = 2;
        if (TextUtils.equals("4", imMessageCenterShowItemData.getOwnerName())) {
            i = 1;
        } else if (TextUtils.equals("7", imMessageCenterShowItemData.getOwnerName())) {
            i = 2;
        }
        if (i > 0) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                i2 = 1;
            }
            TiebaStatic.log(param.param("obj_type", i2).param("obj_locate", i).param("obj_param1", imMessageCenterShowItemData.getUnReadCount()));
        }
        if (CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(imMessageCenterShowItemData.getFriendId())) {
            CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_MSG_CENTER_NOTIFY_SHOW, null, imMessageCenterShowItemData.getFriendName());
        }
    }
}
