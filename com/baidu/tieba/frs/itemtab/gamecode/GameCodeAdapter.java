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
import b.a.e.e.p.l;
import b.a.q0.s.g0.p.b;
import b.a.q0.s.u.c;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.h1;
import b.a.r0.x0.l2.h.a;
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
/* loaded from: classes9.dex */
public class GameCodeAdapter extends RecyclerView.Adapter<GameCodeViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<GameCodeList> f48870a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48871b;

    /* loaded from: classes9.dex */
    public static class GameCodeViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f48872a;

        /* renamed from: b  reason: collision with root package name */
        public EMTextView f48873b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f48874c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f48875d;

        /* renamed from: e  reason: collision with root package name */
        public GameCodeList f48876e;

        /* renamed from: f  reason: collision with root package name */
        public int f48877f;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GameCodeViewHolder f48878e;

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
                this.f48878e = gameCodeViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48878e.gameCodeClickLog(1);
                    this.f48878e.sendGetGameCodeMessage();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GameCodeList f48879e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GameCodeViewHolder f48880f;

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
                this.f48880f = gameCodeViewHolder;
                this.f48879e = gameCodeList;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48880f.gameCodeClickLog(2);
                    ((ClipboardManager) view.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText(null, this.f48879e.claimed_value));
                    new BdTopToast(this.f48880f.f48875d.getContext()).setIcon(true).setContent(TbadkCoreApplication.getInst().getResources().getString(h1.copy_success)).show((ViewGroup) ((Activity) this.f48880f.f48875d.getContext()).findViewById(16908290));
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
            this.f48875d = (TBSpecificationBtn) relativeLayout.getChildAt(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.getChildAt(1);
            this.f48872a = (ImageView) relativeLayout2.getChildAt(0);
            this.f48873b = (EMTextView) relativeLayout2.getChildAt(1);
            this.f48874c = (EMTextView) relativeLayout2.getChildAt(2);
        }

        public void bindData(GameCodeList gameCodeList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gameCodeList) == null) {
                this.f48876e = gameCodeList;
                this.f48877f = getAdapterPosition();
                this.f48873b.setText(gameCodeList.label);
                if (gameCodeList.claimed_status.intValue() == 1) {
                    this.f48874c.setVisibility(8);
                    b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
                    bVar.p(b1.CAM_X0302, b1.CAM_X0101);
                    this.f48875d.setConfig(bVar);
                    this.f48875d.setText(TbadkCoreApplication.getInst().getResources().getString(h1.default_get_gift));
                    this.f48875d.setClickState(true);
                    this.f48875d.setClickable(true);
                    this.f48875d.setOnClickListener(new a(this));
                } else if (gameCodeList.claimed_status.intValue() == 2) {
                    this.f48874c.setVisibility(0);
                    this.f48874c.setText(gameCodeList.claimed_value);
                    b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
                    bVar2.p(b1.CAM_X0302, b1.CAM_X0101);
                    bVar2.i(d1.icon_pure_copy, 0, TBSpecificationButtonConfig.IconType.WEBP);
                    this.f48875d.setConfig(bVar2);
                    this.f48875d.setText(TbadkCoreApplication.getInst().getResources().getString(h1.copy));
                    this.f48875d.setClickState(true);
                    this.f48875d.setClickable(true);
                    this.f48875d.setOnClickListener(new b(this, gameCodeList));
                } else if (gameCodeList.claimed_status.intValue() == 3) {
                    this.f48874c.setVisibility(8);
                    b.a.q0.s.g0.n.b bVar3 = new b.a.q0.s.g0.n.b();
                    bVar3.p(b1.CAM_X0201, b1.CAM_X0109);
                    this.f48875d.setConfig(bVar3);
                    this.f48875d.setText(TbadkCoreApplication.getInst().getResources().getString(h1.game_code_finished));
                    this.f48875d.setClickState(false);
                    this.f48875d.setClickable(false);
                    this.f48875d.setOnClickListener(null);
                }
                if (gameCodeList.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.f48872a, d1.icon_pure_activacode, b1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (gameCodeList.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.f48872a, d1.icon_pure_giftcode, b1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
            }
        }

        public void gameCodeClickLog(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(16);
                bVar.l(this.f48876e.list_id.intValue());
                bVar.n(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }

        public void onChangSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f48876e.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.f48872a, d1.icon_pure_activacode, b1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (this.f48876e.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.f48872a, d1.icon_pure_giftcode, b1.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
                c d2 = c.d(this.f48873b);
                d2.v(b1.CAM_X0105);
                d2.z(c1.T_X06);
                c d3 = c.d(this.f48874c);
                d3.v(b1.CAM_X0109);
                d3.z(c1.T_X09);
                TBSpecificationBtn tBSpecificationBtn = this.f48875d;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.changeSkinType();
                }
            }
        }

        public void sendGetGameCodeMessage() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                MessageManager messageManager = MessageManager.getInstance();
                int i2 = this.f48877f;
                Integer num = this.f48876e.item_id;
                int intValue = num == null ? 0 : num.intValue();
                Integer num2 = this.f48876e.list_id;
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
        this.f48870a = new ArrayList();
        this.f48871b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48870a.size() : invokeV.intValue;
    }

    public void setGameCodeList(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f48870a.clear();
            this.f48870a.addAll(list);
        }
    }

    public void updateAfterGetGameCodeSuccess(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            GameCodeList gameCodeList = this.f48870a.get(aVar.f25976a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f25977b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            this.f48870a.set(aVar.f25976a, builder.build(false));
            notifyItemChanged(aVar.f25976a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull GameCodeViewHolder gameCodeViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gameCodeViewHolder, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(15, i2 + 1)));
            gameCodeViewHolder.bindData(this.f48870a.get(i2));
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
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, l.g(viewGroup.getContext(), c1.tbds125)));
            View tBSpecificationBtn = new TBSpecificationBtn(viewGroup.getContext());
            tBSpecificationBtn.setId(3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(viewGroup.getContext(), c1.tbds177), l.g(viewGroup.getContext(), c1.tbds75));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = l.g(viewGroup.getContext(), c1.M_W_X005);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            relativeLayout.addView(tBSpecificationBtn);
            RelativeLayout relativeLayout2 = new RelativeLayout(viewGroup.getContext());
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setId(1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.g(viewGroup.getContext(), c1.tbds42), l.g(viewGroup.getContext(), c1.tbds42));
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
            layoutParams3.topMargin = l.g(viewGroup.getContext(), c1.tbds2);
            layoutParams3.leftMargin = l.g(viewGroup.getContext(), c1.M_W_X003);
            eMTextView.setLayoutParams(layoutParams3);
            relativeLayout2.addView(eMTextView);
            EMTextView eMTextView2 = new EMTextView(viewGroup.getContext());
            eMTextView2.setSingleLine(true);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(5, eMTextView.getId());
            layoutParams4.addRule(3, eMTextView.getId());
            layoutParams4.topMargin = l.g(viewGroup.getContext(), c1.M_H_X002);
            eMTextView2.setLayoutParams(layoutParams4);
            eMTextView2.setVisibility(8);
            relativeLayout2.addView(eMTextView2);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(9);
            layoutParams5.addRule(0, tBSpecificationBtn.getId());
            layoutParams5.addRule(15);
            layoutParams5.leftMargin = l.g(viewGroup.getContext(), c1.M_W_X005);
            relativeLayout2.setLayoutParams(layoutParams5);
            relativeLayout.addView(relativeLayout2);
            return new GameCodeViewHolder(relativeLayout);
        }
        return (GameCodeViewHolder) invokeLI.objValue;
    }
}
