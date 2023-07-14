package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class b69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i);

        void b();
    }

    /* loaded from: classes5.dex */
    public static class a implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BubbleListData.BubbleData b;

        public a(e eVar, BubbleListData.BubbleData bubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = bubbleData;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BubbleListData.BubbleData b;

        public c(e eVar, BubbleListData.BubbleData bubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = bubbleData;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65536, null, tbPageContext, bubbleData, eVar) != null) || bubbleData == null) {
            return;
        }
        p55 p55Var = new p55(tbPageContext.getPageActivity());
        p55Var.setCanceledOnTouchOutside(false);
        Date date = new Date();
        Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
        String dateStringDay = xi.getDateStringDay(date);
        String dateStringDay2 = xi.getDateStringDay(date2);
        String format = String.format(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f03ac), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092517);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092518);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0108, 1);
        textView.setText(format);
        textView2.setText(dateStringDay + tbPageContext.getString(R.string.obfuscated_res_0x7f0f169f) + dateStringDay2);
        p55Var.setContentView(inflate);
        p55Var.setPositiveButton(R.string.use_immediately, new a(eVar, bubbleData));
        p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(eVar));
        p55Var.create(tbPageContext);
        p55Var.show();
    }

    public static void b(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, tbPageContext, bubbleData, eVar) != null) || bubbleData == null) {
            return;
        }
        p55 p55Var = new p55(tbPageContext.getPageActivity());
        p55Var.setCanceledOnTouchOutside(false);
        p55Var.setMessage(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f03ae), bubbleData.getLevel_name()));
        p55Var.setPositiveButton(R.string.open_now, new c(eVar, bubbleData));
        p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new d(eVar));
        p55Var.create(tbPageContext);
        p55Var.show();
    }
}
