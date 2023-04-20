package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class dw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;
    public SparseArray<String> b;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ dw7 b;

        public a(dw7 dw7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dw7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yh.a(this.a.x);
                ii.Q(this.b.a.getActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    public dw7(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = baseActivity;
    }

    public final void b(ShareItem shareItem, String str, long j, String str2) {
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, str, Long.valueOf(j), str2}) == null) {
            StringBuilder sb = new StringBuilder();
            if (!StringUtils.isNull(str) && !StringUtil.NULL_STRING.equals(str)) {
                if (str.length() > 20) {
                    sb.append(str.substring(0, 20));
                    sb.append(StringHelper.STRING_MORE);
                } else {
                    sb.append(str);
                }
                sb.append(StringUtils.lineSeparator);
            }
            if (j > 0) {
                sb.append(this.a.getActivity().getString(R.string.topic_temperature));
                sb.append(StringHelper.numFormatOver10000(j));
            }
            shareItem.J0 = sb.toString();
            if (StringUtils.isNull(str2)) {
                parse = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            } else {
                parse = Uri.parse(str2);
            }
            shareItem.K0 = parse;
        }
    }

    public final SparseArray<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.b.put(3, "topic_wx_friend");
                this.b.put(4, "topic_qq_zone");
                this.b.put(5, "topic_tencent_weibo");
                this.b.put(6, "topic_sina_weibo");
            }
            return this.b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void d(String str, String str2, String str3, String str4, String str5, String str6, boolean z, long j) {
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (TextUtils.isEmpty(str) && z) {
                BaseActivity<?> baseActivity = this.a;
                baseActivity.showToast(baseActivity.getActivity().getString(R.string.no_hot_topic_data));
                return;
            }
            if (StringUtils.isNull(str3)) {
                str3 = TbConfig.TIEBA_ADDRESS + "mo/q/hotMessage?topic_id=" + str + "&topic_name=" + URLEncoder.encode(str2);
            }
            if (StringUtils.isNull(str4)) {
                parse = null;
            } else {
                parse = Uri.parse(str4);
            }
            ShareItem shareItem = new ShareItem();
            shareItem.v = str2;
            shareItem.w = str5;
            shareItem.x = str3;
            shareItem.b = true;
            shareItem.u = str;
            shareItem.z = parse;
            shareItem.i = true;
            b(shareItem, str5, j, str6);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a.getActivity(), shareItem, true, c());
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
