package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter;
import com.baidu.tieba.ii;
import com.baidu.tieba.pw4;
import com.baidu.tieba.q25;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class ContentCollectView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer t;
    public static int u;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public EMTextView c;
    public EMTextView d;
    public TbImageView e;
    public BarImageView f;
    public AgreeView g;
    public ImageView h;
    public SingleLineEllipsizeTextView i;
    public ContentCollectListAdapter.b j;
    public int k;
    public int l;
    public int m;
    public int n;
    public ThreadData o;
    public int p;
    public int q;
    public View r;
    public CustomMessageListener s;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ContentCollectView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ContentCollectView contentCollectView) {
            super(2921416);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentCollectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(contentCollectView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ContentCollectView contentCollectView;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (contentCollectView = this.a.get()) == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ThreadData)) {
                return;
            }
            ThreadData threadData = (ThreadData) customResponsedMessage.getData();
            if (contentCollectView.getThreadData() != null && threadData != null) {
                ThreadData threadData2 = contentCollectView.getThreadData();
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (threadData2.getBaijiahaoData() != null) {
                    str2 = threadData2.getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        threadData2.setReply_num(threadData.getReply_num());
                        contentCollectView.h(threadData);
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = threadData2.getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    threadData2.setReply_num(threadData.getReply_num());
                    contentCollectView.h(threadData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(287349821, "Lcom/baidu/tieba/homepage/concern/view/ContentCollectView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(287349821, "Lcom/baidu/tieba/homepage/concern/view/ContentCollectView;");
                return;
            }
        }
        t = 1;
    }

    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.o;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.s);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentCollectView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        c();
    }

    public final void h(ThreadData threadData) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, threadData) != null) || threadData == null) {
            return;
        }
        if (threadData.getReply_num() > 0) {
            string = StringHelper.numberUniformFormatExtra(threadData.getReply_num());
        } else {
            string = getContext().getString(R.string.action_comment_default);
        }
        this.c.setText(string);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q25 d = q25.d(this.a);
            d.C(R.string.F_X02);
            d.B(R.dimen.T_X05);
            d.w(R.color.CAM_X0105);
            q25 d2 = q25.d(this.b);
            d2.B(R.dimen.T_X07);
            d2.w(R.color.CAM_X0107);
            q25 d3 = q25.d(this.c);
            d3.B(R.dimen.T_X08);
            d3.w(R.color.CAM_X0108);
            q25 d4 = q25.d(this.d);
            d4.w(R.color.CAM_X0101);
            d4.C(R.string.F_X02);
            d4.o(R.string.J_X01);
            d4.f(R.color.CAM_X0607);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_bar34, SkinManager.getColor(R.color.CAM_X0107), null);
            int g = ii.g(getContext(), R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, g, g);
            this.i.setCompoundDrawables(null, null, pureDrawable, null);
            this.i.setCompoundDrawablePadding(ii.g(getContext(), R.dimen.M_W_X002));
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
            this.g.P(TbadkCoreApplication.getInst().getSkinType());
            this.e.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            WebPManager.setPureDrawable(this.h, R.drawable.icon_pure_card_comment18, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07cb, (ViewGroup) this, true);
            setOrientation(1);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.bottomMargin = ii.g(getContext(), R.dimen.M_H_X003);
            setLayoutParams(marginLayoutParams);
            this.k = ii.g(getContext(), R.dimen.tbds235);
            this.l = ii.g(getContext(), R.dimen.tbds62);
            this.n = ii.g(getContext(), R.dimen.tbds115);
            this.m = ii.g(getContext(), R.dimen.tbds3);
            u = (((ii.l(getContext()) - (ii.g(getContext(), R.dimen.M_W_X004) * 5)) - ii.g(getContext(), R.dimen.M_W_X006)) - ii.g(getContext(), R.dimen.M_W_X005)) - this.k;
            this.a = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0923f2);
            this.b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090782);
            this.d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0916e0);
            this.f = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090333);
            this.e = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ff4);
            this.i = (SingleLineEllipsizeTextView) findViewById(R.id.obfuscated_res_0x7f090351);
            this.h = (ImageView) findViewById(R.id.comment_icon);
            this.c = (EMTextView) findViewById(R.id.comment_num);
            this.g = (AgreeView) findViewById(R.id.agree_and_disagreeview);
            this.a.setLineSpacing(ii.g(getContext(), R.dimen.M_T_X002), 1.0f);
            this.b.setLineSpacing(ii.g(getContext(), R.dimen.M_T_X002), 1.0f);
            d();
            e();
            f();
            this.i.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.h.setOnClickListener(this);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setResourceId(R.raw.obfuscated_res_0x7f11002e, R.raw.lottie_disagree);
            this.g.getImgAgree().setImageAssetsFolder("images");
            this.g.setNormalColorResourceId(R.color.CAM_X0108);
            this.g.setAgreeAlone(true);
            AgreeView agreeView = this.g;
            int i = this.l;
            agreeView.u(i, i, this.n, this.m);
            this.g.setFrom(this.p);
            this.g.setIsAgreeNumClick(true);
            this.g.setAgreeAnimationResource();
            pw4 pw4Var = new pw4();
            pw4Var.b = 1;
            pw4Var.h = 1;
            pw4Var.g = 1;
            pw4Var.c = 7;
            pw4Var.f = this.q;
            this.g.setStatisticData(pw4Var);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            int i = this.k;
            marginLayoutParams.width = i;
            marginLayoutParams.height = (i * 3) / 4;
            this.e.setLayoutParams(marginLayoutParams);
            this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.e.setDrawCorner(true);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.e.setRadiusById(R.string.J_X05);
            this.e.setForegroundColor(0);
            this.e.setBorderSurroundContent(true);
            this.e.setDrawBorder(true);
            this.e.setBorderWidth(ii.g(getContext(), R.dimen.tbds1));
            this.e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.setDrawCorner(true);
            this.f.setConrers(15);
            this.f.setRadius(20);
            this.f.setForegroundColor(0);
            this.f.setAutoChangeStyle(true);
            this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f.setPlaceHolder(1);
        }
    }

    public final void g(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (!ListUtils.isEmpty(medias)) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.isEmpty(linkedList)) {
                    return;
                }
                this.e.N(ThreadCardUtils.getThumbnailsUrl((MediaData) linkedList.get(0)), 10, false);
                if (linkedList.size() > t.intValue()) {
                    this.d.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - t.intValue())}));
                    this.d.setVisibility(0);
                    return;
                }
                this.d.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ContentCollectListAdapter.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2 != this.f && view2 != this.i) {
                if ((view2 == this.c || view2 == this.h) && (bVar = this.j) != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            ContentCollectListAdapter.b bVar2 = this.j;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    public void setCommonClickListener(ContentCollectListAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.p = i;
            AgreeView agreeView = this.g;
            if (agreeView != null) {
                agreeView.setFrom(i);
            }
        }
    }

    public void setsourceForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.q = i;
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, threadData) != null) || threadData == null) {
            return;
        }
        this.o = threadData;
        int i = 2;
        if (threadData.getIsNoTitle() == 1) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setText(threadData.getAbstractText());
            i = (2 - ri.a(u, this.b.getPaint(), this.b.getText().toString(), 2)) + 1;
        }
        this.a.setMaxLines(i);
        this.a.setText(threadData.getTitleText());
        this.i.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), StringHelper.cutStringWithEllipsisStrict(threadData.getForum_name(), 17)));
        this.g.setData(threadData.getAgreeData());
        if (threadData.getForumData() != null) {
            this.f.N(threadData.getForumData().a(), 10, false);
        } else {
            this.f.N(threadData.getForumAvatar(), 10, false);
        }
        h(threadData);
        g(threadData);
        b();
    }
}
