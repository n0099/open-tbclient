package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.lla;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverPendantDragView;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dma extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public CoverSeekBar b;
    public LinearLayout c;
    public bma d;
    public HListView e;
    public lla f;
    public CoverPendantDragView g;

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements lla.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dma a;

        public a(dma dmaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dmaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dmaVar;
        }

        @Override // com.baidu.tieba.lla.b
        public void a(View view2, int i, PendantData pendantData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, pendantData) == null) {
                this.a.g.u(view2, pendantData);
                StatisticItem statisticItem = new StatisticItem("c12305");
                statisticItem.param("obj_locate", i + 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CoverSeekBar.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dma a;

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(dma dmaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dmaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dmaVar;
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log("c12304");
            }
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                int duration = (int) ((this.a.d.S().getDuration() * i) / 1000);
                this.a.b.setProgressImage(i, duration);
                this.a.d.S().seekTo(duration);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dma a;

        public c(dma dmaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dmaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dmaVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dma a;

        public d(dma dmaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dmaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dmaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.k(this.a.b.getCurrentPosition());
                this.a.d.Y();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dma(BdPageContext bdPageContext, bma bmaVar) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bmaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = bmaVar;
        View inflate = LayoutInflater.from(bdPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0282, (ViewGroup) null);
        this.a = inflate;
        inflate.getResources();
        I();
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.g.K(z);
            if (z) {
                CoverSeekBar coverSeekBar = this.b;
                coverSeekBar.k(coverSeekBar.getCurrentPosition());
            }
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setData(str);
    }

    public void R(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.addAll(0, D());
            this.f.c(list);
        }
    }

    public Bitmap A(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            this.g.A();
            String text = this.g.getText();
            if (bitmap == null || TextUtils.isEmpty(text)) {
                return null;
            }
            int width = this.d.S().getWidth();
            int height = this.d.S().getHeight();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Bitmap tempBitmap = this.g.getTempBitmap();
            if (tempBitmap != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(width2 / width, height2 / height);
                Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.d.S().getLeft(), this.d.S().getTop(), width, height, matrix, true);
                if (createBitmap2 != null) {
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                }
            }
            canvas.save();
            canvas.restore();
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public void H(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view2.findViewById(R.id.obfuscated_res_0x7f090802);
            this.g = coverPendantDragView;
            coverPendantDragView.setParentViewController(this);
            this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09080c);
            if (SharedPrefHelper.getInstance().getBoolean("video_cover_first_in", true)) {
                this.c.setVisibility(0);
                this.c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new c(this)).start();
                SharedPrefHelper.getInstance().putBoolean("video_cover_first_in", false);
            }
        }
    }

    public final List<PendantData> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, new PendantData(0));
            arrayList.add(1, new PendantData(1));
            arrayList.add(2, new PendantData(2));
            arrayList.add(3, new PendantData(3));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g.getText();
        }
        return (String) invokeV.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.A();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SafeHandler.getInst().postDelayed(new d(this), 500L);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            CoverSeekBar coverSeekBar = this.b;
            if (coverSeekBar != null) {
                coverSeekBar.j();
            }
            CoverPendantDragView coverPendantDragView = this.g;
            if (coverPendantDragView != null) {
                coverPendantDragView.I();
            }
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = (CoverSeekBar) this.a.findViewById(R.id.obfuscated_res_0x7f090806);
            this.e = (HListView) this.a.findViewById(R.id.obfuscated_res_0x7f091b5e);
            lla llaVar = new lla(getPageContext());
            this.f = llaVar;
            llaVar.d(new a(this));
            this.e.setAdapter((ListAdapter) this.f);
            this.f.c(D());
            this.b.setOnProgressChanged(new b(this));
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g.setVideoSize(this.d.S().getWidth(), this.d.S().getHeight());
            this.g.setVideoLocation(this.d.S().getLeft(), this.d.S().getTop(), this.d.S().getRight(), this.d.S().getBottom());
        }
    }

    public void J(BdPageContext bdPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, bdPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }
}
