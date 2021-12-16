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
import c.a.d.f.p.m;
import c.a.r0.s.i0.p.b;
import c.a.r0.s.v.c;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.e1;
import c.a.s0.d1.i1;
import c.a.s0.d1.m2.h.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes12.dex */
public class GameCodeAdapter extends RecyclerView.Adapter<GameCodeViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GameCodeList> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45073b;

    /* loaded from: classes12.dex */
    public static class GameCodeViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public EMTextView f45074b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f45075c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f45076d;

        /* renamed from: e  reason: collision with root package name */
        public GameCodeList f45077e;

        /* renamed from: f  reason: collision with root package name */
        public int f45078f;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GameCodeViewHolder f45079e;

            public a(GameCodeViewHolder gameCodeViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gameCodeViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45079e = gameCodeViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f45079e.gameCodeClickLog(1);
                    this.f45079e.sendGetGameCodeMessage();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GameCodeList f45080e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GameCodeViewHolder f45081f;

            public b(GameCodeViewHolder gameCodeViewHolder, GameCodeList gameCodeList) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gameCodeViewHolder, gameCodeList};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45081f = gameCodeViewHolder;
                this.f45080e = gameCodeList;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f45081f.gameCodeClickLog(2);
                    ((ClipboardManager) view.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText(null, this.f45080e.claimed_value));
                    new BdTopToast(this.f45081f.f45076d.getContext()).setIcon(true).setContent(TbadkCoreApplication.getInst().getResources().getString(i1.copy_success)).show((ViewGroup) ((Activity) this.f45081f.f45076d.getContext()).findViewById(16908290));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            RelativeLayout relativeLayout = (RelativeLayout) view;
            this.f45076d = (TBSpecificationBtn) relativeLayout.getChildAt(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.getChildAt(1);
            this.a = (ImageView) relativeLayout2.getChildAt(0);
            this.f45074b = (EMTextView) relativeLayout2.getChildAt(1);
            this.f45075c = (EMTextView) relativeLayout2.getChildAt(2);
        }

        public void bindData(GameCodeList gameCodeList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gameCodeList) == null) {
                this.f45077e = gameCodeList;
                this.f45078f = getAdapterPosition();
                this.f45074b.setText(gameCodeList.label);
                if (gameCodeList.claimed_status.intValue() == 1) {
                    this.f45075c.setVisibility(8);
                    c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
                    bVar.p(c1.CAM_X0302, c1.CAM_X0101);
                    this.f45076d.setConfig(bVar);
                    this.f45076d.setText(TbadkCoreApplication.getInst().getResources().getString(i1.default_get_gift));
                    this.f45076d.setClickState(true);
                    this.f45076d.setClickable(true);
                    this.f45076d.setOnClickListener(new a(this));
                } else if (gameCodeList.claimed_status.intValue() == 2) {
                    this.f45075c.setVisibility(0);
                    this.f45075c.setText(gameCodeList.claimed_value);
                    c.a.r0.s.i0.n.b bVar2 = new c.a.r0.s.i0.n.b();
                    bVar2.p(c1.CAM_X0302, c1.CAM_X0101);
                    bVar2.i(e1.icon_pure_copy, 0, TBSpecificationButtonConfig.IconType.WEBP);
                    this.f45076d.setConfig(bVar2);
                    this.f45076d.setText(TbadkCoreApplication.getInst().getResources().getString(i1.copy));
                    this.f45076d.setClickState(true);
                    this.f45076d.setClickable(true);
                    this.f45076d.setOnClickListener(new b(this, gameCodeList));
                } else if (gameCodeList.claimed_status.intValue() == 3) {
                    this.f45075c.setVisibility(8);
                    c.a.r0.s.i0.n.b bVar3 = new c.a.r0.s.i0.n.b();
                    bVar3.p(c1.CAM_X0201, c1.CAM_X0109);
                    this.f45076d.setConfig(bVar3);
                    this.f45076d.setText(TbadkCoreApplication.getInst().getResources().getString(i1.game_code_finished));
                    this.f45076d.setClickState(false);
                    this.f45076d.setClickable(false);
                    this.f45076d.setOnClickListener(null);
                }
                if (gameCodeList.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.a, e1.icon_pure_activacode, c1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (gameCodeList.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.a, e1.icon_pure_giftcode, c1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
            }
        }

        public void gameCodeClickLog(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.r0.s.i0.p.b bVar = new c.a.r0.s.i0.p.b(16);
                bVar.m(this.f45077e.list_id.intValue());
                bVar.o(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }

        public void onChangSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f45077e.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.a, e1.icon_pure_activacode, c1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (this.f45077e.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.a, e1.icon_pure_giftcode, c1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
                c d2 = c.d(this.f45074b);
                d2.v(c1.CAM_X0105);
                d2.z(d1.T_X06);
                c d3 = c.d(this.f45075c);
                d3.v(c1.CAM_X0109);
                d3.z(d1.T_X09);
                TBSpecificationBtn tBSpecificationBtn = this.f45076d;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.changeSkinType();
                }
            }
        }

        public void sendGetGameCodeMessage() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                MessageManager messageManager = MessageManager.getInstance();
                int i2 = this.f45078f;
                Integer num = this.f45077e.item_id;
                int intValue = num == null ? 0 : num.intValue();
                Integer num2 = this.f45077e.list_id;
                messageManager.sendMessage(new GameCodeGetMsg(i2, intValue, num2 != null ? num2.intValue() : 0));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f45073b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    public void setGameCodeList(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
        }
    }

    public void updateAfterGetGameCodeSuccess(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            GameCodeList gameCodeList = this.a.get(aVar.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f16135b;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull GameCodeViewHolder gameCodeViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gameCodeViewHolder, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(15, i2 + 1)));
            gameCodeViewHolder.bindData(this.a.get(i2));
            gameCodeViewHolder.onChangSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public GameCodeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, m.f(viewGroup.getContext(), d1.tbds125)));
            View tBSpecificationBtn = new TBSpecificationBtn(viewGroup.getContext());
            tBSpecificationBtn.setId(3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.f(viewGroup.getContext(), d1.tbds177), m.f(viewGroup.getContext(), d1.tbds75));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = m.f(viewGroup.getContext(), d1.M_W_X005);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            relativeLayout.addView(tBSpecificationBtn);
            RelativeLayout relativeLayout2 = new RelativeLayout(viewGroup.getContext());
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setId(1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m.f(viewGroup.getContext(), d1.tbds42), m.f(viewGroup.getContext(), d1.tbds42));
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
            layoutParams3.topMargin = m.f(viewGroup.getContext(), d1.tbds2);
            layoutParams3.leftMargin = m.f(viewGroup.getContext(), d1.M_W_X003);
            eMTextView.setLayoutParams(layoutParams3);
            relativeLayout2.addView(eMTextView);
            EMTextView eMTextView2 = new EMTextView(viewGroup.getContext());
            eMTextView2.setSingleLine(true);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(5, eMTextView.getId());
            layoutParams4.addRule(3, eMTextView.getId());
            layoutParams4.topMargin = m.f(viewGroup.getContext(), d1.M_H_X002);
            eMTextView2.setLayoutParams(layoutParams4);
            eMTextView2.setVisibility(8);
            relativeLayout2.addView(eMTextView2);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(9);
            layoutParams5.addRule(0, tBSpecificationBtn.getId());
            layoutParams5.addRule(15);
            layoutParams5.leftMargin = m.f(viewGroup.getContext(), d1.M_W_X005);
            relativeLayout2.setLayoutParams(layoutParams5);
            relativeLayout.addView(relativeLayout2);
            return new GameCodeViewHolder(relativeLayout);
        }
        return (GameCodeViewHolder) invokeLI.objValue;
    }
}
