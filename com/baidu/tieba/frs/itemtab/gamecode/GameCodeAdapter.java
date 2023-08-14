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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.ea5;
import com.baidu.tieba.ho7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.x95;
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
    public Context b;

    /* loaded from: classes5.dex */
    public static class GameCodeViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public EMTextView b;
        public EMTextView c;
        public TBSpecificationBtn d;
        public GameCodeList e;
        public int f;

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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.d(1);
                    this.a.f();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GameCodeList a;
            public final /* synthetic */ GameCodeViewHolder b;

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
                this.b = gameCodeViewHolder;
                this.a = gameCodeList;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.d(2);
                    ((ClipboardManager) view2.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText(null, this.a.claimed_value));
                    new BdTopToast(this.b.d.getContext()).setIcon(true).setContent(TbadkCoreApplication.getInst().getResources().getString(R.string.copy_success)).show((ViewGroup) ((Activity) this.b.d.getContext()).findViewById(16908290));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GameCodeViewHolder(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            RelativeLayout relativeLayout = (RelativeLayout) view2;
            this.d = (TBSpecificationBtn) relativeLayout.getChildAt(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.getChildAt(1);
            this.a = (ImageView) relativeLayout2.getChildAt(0);
            this.b = (EMTextView) relativeLayout2.getChildAt(1);
            this.c = (EMTextView) relativeLayout2.getChildAt(2);
        }

        public void c(GameCodeList gameCodeList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gameCodeList) == null) {
                this.e = gameCodeList;
                this.f = getAdapterPosition();
                this.b.setText(gameCodeList.label);
                if (gameCodeList.claimed_status.intValue() == 1) {
                    this.c.setVisibility(8);
                    x95 x95Var = new x95();
                    x95Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
                    this.d.setConfig(x95Var);
                    this.d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.default_get_gift));
                    this.d.setClickState(true);
                    this.d.setClickable(true);
                    this.d.setOnClickListener(new a(this));
                } else if (gameCodeList.claimed_status.intValue() == 2) {
                    this.c.setVisibility(0);
                    this.c.setText(gameCodeList.claimed_value);
                    x95 x95Var2 = new x95();
                    x95Var2.s(R.color.CAM_X0302, R.color.CAM_X0101);
                    x95Var2.j(R.drawable.obfuscated_res_0x7f080b2b, 0, TBSpecificationButtonConfig.IconType.WEBP);
                    this.d.setConfig(x95Var2);
                    this.d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04e1));
                    this.d.setClickState(true);
                    this.d.setClickable(true);
                    this.d.setOnClickListener(new b(this, gameCodeList));
                } else if (gameCodeList.claimed_status.intValue() == 3) {
                    this.c.setVisibility(8);
                    x95 x95Var3 = new x95();
                    x95Var3.s(R.color.CAM_X0201, R.color.CAM_X0109);
                    this.d.setConfig(x95Var3);
                    this.d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f08bd));
                    this.d.setClickState(false);
                    this.d.setClickable(false);
                    this.d.setOnClickListener(null);
                }
                if (gameCodeList.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f080b01, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (gameCodeList.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f080b49, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ea5 ea5Var = new ea5(16);
                ea5Var.o(this.e.list_id.intValue());
                ea5Var.q(i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ea5Var));
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.e.type.intValue() == 1) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f080b01, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                } else if (this.e.type.intValue() == 2) {
                    WebPManager.setPureDrawable(this.a, R.drawable.obfuscated_res_0x7f080b49, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                }
                EMManager.from(this.b).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X06);
                EMManager.from(this.c).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
                TBSpecificationBtn tBSpecificationBtn = this.d;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.k();
                }
            }
        }

        public void f() {
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                MessageManager messageManager = MessageManager.getInstance();
                int i = this.f;
                Integer num = this.e.item_id;
                int i2 = 0;
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                Integer num2 = this.e.list_id;
                if (num2 != null) {
                    i2 = num2.intValue();
                }
                messageManager.sendMessage(new GameCodeGetMsg(i, intValue, i2));
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
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@NonNull GameCodeViewHolder gameCodeViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gameCodeViewHolder, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new ea5(15, i + 1)));
            gameCodeViewHolder.c(this.a.get(i));
            gameCodeViewHolder.e();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m */
    public GameCodeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.tbds125)));
            View tBSpecificationBtn = new TBSpecificationBtn(viewGroup.getContext());
            tBSpecificationBtn.setId(3);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.tbds177), BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.tbds75));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.M_W_X005);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            relativeLayout.addView(tBSpecificationBtn);
            RelativeLayout relativeLayout2 = new RelativeLayout(viewGroup.getContext());
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setId(1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.tbds42), BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.tbds42));
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
            layoutParams3.topMargin = BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.tbds2);
            layoutParams3.leftMargin = BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.M_W_X003);
            eMTextView.setLayoutParams(layoutParams3);
            relativeLayout2.addView(eMTextView);
            EMTextView eMTextView2 = new EMTextView(viewGroup.getContext());
            eMTextView2.setSingleLine(true);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(5, eMTextView.getId());
            layoutParams4.addRule(3, eMTextView.getId());
            layoutParams4.topMargin = BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.M_H_X002);
            eMTextView2.setLayoutParams(layoutParams4);
            eMTextView2.setVisibility(8);
            relativeLayout2.addView(eMTextView2);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(9);
            layoutParams5.addRule(0, tBSpecificationBtn.getId());
            layoutParams5.addRule(15);
            layoutParams5.leftMargin = BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.M_W_X005);
            relativeLayout2.setLayoutParams(layoutParams5);
            relativeLayout.addView(relativeLayout2);
            return new GameCodeViewHolder(relativeLayout);
        }
        return (GameCodeViewHolder) invokeLI.objValue;
    }

    public void n(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
        }
    }

    public void o(ho7 ho7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ho7Var) == null) {
            GameCodeList gameCodeList = this.a.get(ho7Var.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = ho7Var.b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            this.a.set(ho7Var.a, builder.build(false));
            notifyItemChanged(ho7Var.a);
        }
    }
}
