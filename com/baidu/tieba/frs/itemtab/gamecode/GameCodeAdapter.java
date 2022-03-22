package com.baidu.tieba.frs.itemtab.gamecode;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.o0.r.l0.p.b;
import c.a.o0.r.v.c;
import c.a.p0.f1.d2.h.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes5.dex */
public class GameCodeAdapter extends RecyclerView.Adapter<GameCodeViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GameCodeList> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f32743b;

    /* loaded from: classes5.dex */
    public static class GameCodeViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public EMTextView f32744b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f32745c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f32746d;

        /* renamed from: e  reason: collision with root package name */
        public GameCodeList f32747e;

        /* renamed from: f  reason: collision with root package name */
        public int f32748f;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GameCodeViewHolder a;

            public a(GameCodeViewHolder gameCodeViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gameCodeViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gameCodeViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.c(1);
                    this.a.e();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GameCodeList a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ GameCodeViewHolder f32749b;

            public b(GameCodeViewHolder gameCodeViewHolder, GameCodeList gameCodeList) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gameCodeViewHolder, gameCodeList};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32749b = gameCodeViewHolder;
                this.a = gameCodeList;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f32749b.c(2);
                    ((ClipboardManager) view.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText(null, this.a.claimed_value));
                    BdTopToast bdTopToast = new BdTopToast(this.f32749b.f32746d.getContext());
                    bdTopToast.i(true);
                    bdTopToast.h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0439));
                    bdTopToast.j((ViewGroup) ((Activity) this.f32749b.f32746d.getContext()).findViewById(16908290));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GameCodeViewHolder(@NonNull View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            RelativeLayout relativeLayout = (RelativeLayout) view;
            this.f32746d = (TBSpecificationBtn) relativeLayout.getChildAt(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.getChildAt(1);
            this.a = (ImageView) relativeLayout2.getChildAt(0);
            this.f32744b = (EMTextView) relativeLayout2.getChildAt(1);
            this.f32745c = (EMTextView) relativeLayout2.getChildAt(2);
        }

        public void b(GameCodeList gameCodeList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gameCodeList) == null) {
                this.f32747e = gameCodeList;
                this.f32748f = getAdapterPosition();
                this.f32744b.setText(gameCodeList.label);
                if (gameCodeList.claimed_status.intValue() == 1) {
                    this.f32745c.setVisibility(8);
                    c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                    bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
                    this.f32746d.setConfig(bVar);
                    this.f32746d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0478));
                    this.f32746d.setClickState(true);
                    this.f32746d.setClickable(true);
                    this.f32746d.setOnClickListener(new a(this));
                } else if (gameCodeList.claimed_status.intValue() == 2) {
                    this.f32745c.setVisibility(0);
                    this.f32745c.setText(gameCodeList.claimed_value);
                    c.a.o0.r.l0.n.b bVar2 = new c.a.o0.r.l0.n.b();
                    bVar2.p(R.color.CAM_X0302, R.color.CAM_X0101);
                    bVar2.i(R.drawable.obfuscated_res_0x7f0808f5, 0, TBSpecificationButtonConfig.IconType.WEBP);
                    this.f32746d.setConfig(bVar2);
                    this.f32746d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0435));
                    this.f32746d.setClickState(true);
                    this.f32746d.setClickable(true);
                    this.f32746d.setOnClickListener(new b(this, gameCodeList));
                } else if (gameCodeList.claimed_status.intValue() == 3) {
                    this.f32745c.setVisibility(8);
                    c.a.o0.r.l0.n.b bVar3 = new c.a.o0.r.l0.n.b();
                    bVar3.p(R.color.CAM_X0201, R.color.CAM_X0109);
                    this.f32746d.setConfig(bVar3);
                    this.f32746d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0777));
                    this.f32746d.setClickState(false);
                    this.f32746d.setClickable(false);
                    this.f32746d.setOnClickListener(null);
                }
                if (gameCodeList.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f0808d2, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (gameCodeList.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
            }
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                c.a.o0.r.l0.p.b bVar = new c.a.o0.r.l0.p.b(16);
                bVar.m(this.f32747e.list_id.intValue());
                bVar.o(i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f32747e.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f0808d2, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (this.f32747e.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
                c d2 = c.d(this.f32744b);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X06);
                c d3 = c.d(this.f32745c);
                d3.v(R.color.CAM_X0109);
                d3.z(R.dimen.T_X09);
                TBSpecificationBtn tBSpecificationBtn = this.f32746d;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.k();
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                MessageManager messageManager = MessageManager.getInstance();
                int i = this.f32748f;
                Integer num = this.f32747e.item_id;
                int intValue = num == null ? 0 : num.intValue();
                Integer num2 = this.f32747e.list_id;
                messageManager.sendMessage(new GameCodeGetMsg(i, intValue, num2 != null ? num2.intValue() : 0));
            }
        }
    }

    public GameCodeAdapter(Context context) {
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
        this.a = new ArrayList();
        this.f32743b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull GameCodeViewHolder gameCodeViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, gameCodeViewHolder, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(15, i + 1)));
            gameCodeViewHolder.b(this.a.get(i));
            gameCodeViewHolder.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public GameCodeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, n.f(viewGroup.getContext(), R.dimen.tbds125)));
            View tBSpecificationBtn = new TBSpecificationBtn(viewGroup.getContext());
            tBSpecificationBtn.setId(3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.f(viewGroup.getContext(), R.dimen.tbds177), n.f(viewGroup.getContext(), R.dimen.tbds75));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = n.f(viewGroup.getContext(), R.dimen.M_W_X005);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            relativeLayout.addView(tBSpecificationBtn);
            RelativeLayout relativeLayout2 = new RelativeLayout(viewGroup.getContext());
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setId(1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(n.f(viewGroup.getContext(), R.dimen.tbds42), n.f(viewGroup.getContext(), R.dimen.tbds42));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            imageView.setLayoutParams(layoutParams2);
            relativeLayout2.addView(imageView);
            EMTextView eMTextView = new EMTextView(viewGroup.getContext());
            eMTextView.setId(2);
            eMTextView.setSingleLine(true);
            eMTextView.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(1, imageView.getId());
            layoutParams3.addRule(6, imageView.getId());
            layoutParams3.addRule(8, imageView.getId());
            layoutParams3.addRule(10);
            layoutParams3.topMargin = n.f(viewGroup.getContext(), R.dimen.tbds2);
            layoutParams3.leftMargin = n.f(viewGroup.getContext(), R.dimen.M_W_X003);
            eMTextView.setLayoutParams(layoutParams3);
            relativeLayout2.addView(eMTextView);
            EMTextView eMTextView2 = new EMTextView(viewGroup.getContext());
            eMTextView2.setSingleLine(true);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(5, eMTextView.getId());
            layoutParams4.addRule(3, eMTextView.getId());
            layoutParams4.topMargin = n.f(viewGroup.getContext(), R.dimen.M_H_X002);
            eMTextView2.setLayoutParams(layoutParams4);
            eMTextView2.setVisibility(8);
            relativeLayout2.addView(eMTextView2);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(9);
            layoutParams5.addRule(0, tBSpecificationBtn.getId());
            layoutParams5.addRule(15);
            layoutParams5.leftMargin = n.f(viewGroup.getContext(), R.dimen.M_W_X005);
            relativeLayout2.setLayoutParams(layoutParams5);
            relativeLayout.addView(relativeLayout2);
            return new GameCodeViewHolder(relativeLayout);
        }
        return (GameCodeViewHolder) invokeLI.objValue;
    }

    public void f(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
        }
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            GameCodeList gameCodeList = this.a.get(aVar.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f13936b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            this.a.set(aVar.a, builder.build(false));
            notifyItemChanged(aVar.a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
    }
}
