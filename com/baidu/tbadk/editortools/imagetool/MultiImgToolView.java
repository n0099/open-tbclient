package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ea5;
import com.baidu.tieba.jn;
import com.baidu.tieba.l75;
import com.baidu.tieba.mc;
import com.baidu.tieba.na5;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.tieba.u75;
import com.baidu.tieba.z65;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class MultiImgToolView extends DragContainer implements l75, DragHorizonScrollView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean s;
    public transient /* synthetic */ FieldHolder $fh;
    public DragHorizonScrollView e;
    public TextView f;
    public DragLayer g;
    public WriteImagesInfo h;
    public ea5 i;
    public c j;
    public EditorTools k;
    public int l;
    public String m;
    public int n;
    public int o;
    public boolean p;
    public String q;
    public b r;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2025497908, "Lcom/baidu/tbadk/editortools/imagetool/MultiImgToolView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2025497908, "Lcom/baidu/tbadk/editortools/imagetool/MultiImgToolView;");
        }
    }

    @Override // com.baidu.tieba.l75
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WriteImagesInfo a;
        public Context b;
        public ea5 c;
        public l75 d;
        public b e;
        public boolean f;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes3.dex */
        public class a implements aa5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup a;

            public a(c cVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = viewGroup;
            }

            @Override // com.baidu.tieba.aa5
            public void a(jn jnVar, String str, boolean z) {
                TbImageView tbImageView;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLLZ(1048576, this, jnVar, str, z) == null) && (tbImageView = (TbImageView) this.a.findViewWithTag(str)) != null && jnVar != null) {
                    tbImageView.invalidate();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup a;
            public final /* synthetic */ c b;

            public b(c cVar, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int indexOfChild;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (indexOfChild = this.a.indexOfChild(view2)) >= 0) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) this.b.getItem(indexOfChild);
                    boolean z = true;
                    if (imageFileInfo == null || !new File(imageFileInfo.getFilePath()).exists()) {
                        z = false;
                    }
                    if (!z) {
                        zi.M(this.b.b, R.string.editor_mutiiamge_image_error);
                    } else if (this.b.d != null) {
                        this.b.d.J(new z65(15, 0, Integer.valueOf(indexOfChild)));
                    }
                }
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.imagetool.MultiImgToolView$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0210c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrameLayout a;
            public final /* synthetic */ c b;

            public View$OnClickListenerC0210c(c cVar, FrameLayout frameLayout) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, frameLayout};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = frameLayout;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.e != null) {
                    this.b.e.a(this.a);
                }
            }
        }

        public c(Context context, ea5 ea5Var, l75 l75Var, b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, ea5Var, l75Var, bVar, Boolean.valueOf(z)};
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
            this.f = true;
            this.b = context;
            this.c = ea5Var;
            this.d = l75Var;
            this.e = bVar;
            this.f = z;
        }

        public void d(WriteImagesInfo writeImagesInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeImagesInfo) == null) {
                this.a = writeImagesInfo;
            }
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.a.getChosedFiles().get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                WriteImagesInfo writeImagesInfo = this.a;
                if (writeImagesInfo == null) {
                    return 0;
                }
                return writeImagesInfo.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = (FrameLayout) LayoutInflater.from(this.b).inflate(R.layout.editor_muti_image_item, (ViewGroup) null);
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.a.getChosedFiles(), i);
                if (imageFileInfo == null) {
                    return null;
                }
                int measuredWidth = (viewGroup.getMeasuredWidth() - (this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ee) * 2)) + this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
                FrameLayout frameLayout = (FrameLayout) view2;
                LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.iv_container);
                FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.shadow_container);
                TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091083);
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(imageFileInfo.isLong());
                if (measuredWidth > 0) {
                    int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                    int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                    SkinManager.setBackgroundResource(frameLayout2, R.drawable.bg_add_photo);
                    frameLayout2.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(na5.g(paddingRight, measuredHeight));
                    tbImageView.setTag(imageFileInfo.toCachedKey(true));
                    if (this.c.d(imageFileInfo, new a(this, viewGroup), true) != null) {
                        tbImageView.invalidate();
                    }
                }
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
                if (this.f) {
                    frameLayout.setOnClickListener(new b(this, viewGroup));
                }
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f0907bd);
                SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_close);
                imageView.setOnClickListener(new View$OnClickListenerC0210c(this, frameLayout));
                frameLayout.setContentDescription(frameLayout.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
                return frameLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImgToolView a;

        public a(MultiImgToolView multiImgToolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgToolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImgToolView;
        }

        @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.e.m()) {
                return;
            }
            this.a.delete(view2);
            int delete = this.a.e.delete(view2);
            if (delete >= 0 && delete < this.a.h.getChosedFiles().size()) {
                ImageFileInfo remove = this.a.h.getChosedFiles().remove(delete);
                if (remove.isTempFile()) {
                    mc.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                int maxItemNum = this.a.e.getMaxItemNum();
                int size = this.a.h.size();
                this.a.f.setText(this.a.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                int size2 = this.a.h.getChosedFiles().size();
                if (this.a.k != null) {
                    this.a.k.C(new z65(this.a.n, -1, null));
                    if (size2 > 0) {
                        this.a.k.C(new z65(2, this.a.o, String.valueOf(size2)));
                    } else {
                        this.a.k.C(new z65(2, this.a.o, null));
                    }
                    if (maxItemNum == 1 && size2 == 0) {
                        if (this.a.p) {
                            this.a.k.C(new z65(1, 2, null));
                            return;
                        }
                        MultiImgToolView multiImgToolView = this.a;
                        multiImgToolView.k(multiImgToolView.h, true);
                        this.a.f.setText(this.a.q);
                        this.a.k.invalidate();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImgToolView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.m = null;
        this.n = 13;
        this.o = 10;
        this.p = false;
        this.r = new a(this);
    }

    @Override // com.baidu.tieba.a75
    public void A(z65 z65Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, z65Var) != null) || z65Var == null) {
            return;
        }
        int i = z65Var.a;
        if (i != 9) {
            if (i == 12 && (obj = z65Var.c) != null && (obj instanceof u75)) {
                k(((u75) obj).a, ((u75) obj).b);
                return;
            }
            return;
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        J(new z65(2, this.o, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = 13;
        this.o = 10;
        this.p = false;
        this.r = new a(this);
    }

    @Override // com.baidu.tieba.l75
    public void J(z65 z65Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z65Var) == null) && (editorTools = this.k) != null) {
            editorTools.C(z65Var);
        }
    }

    @Override // com.baidu.tieba.l75
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.common_color_10255);
        }
    }

    public void setAsyncLocalImageLoader(ea5 ea5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ea5Var) == null) {
            this.i = ea5Var;
        }
    }

    public void setDefaultTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.m = str;
        }
    }

    public void setDeleteAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tieba.l75
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.k = editorTools;
        }
    }

    public void setNeedQuit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.p = z;
        }
    }

    public void setNoPicTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (StringUtils.isNULL(str)) {
                this.q = " ";
            } else {
                this.q = str;
            }
        }
    }

    public void setTargetToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.l75
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.l = i;
        }
    }

    @Override // com.baidu.tieba.l75
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (DragHorizonScrollView) invokeV.objValue;
    }

    public DragLayer getDragLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (DragLayer) invokeV.objValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h.getChosedFiles().size();
        }
        return invokeV.intValue;
    }

    public TextView getMutiImageTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l75
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l75
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    public final void k(WriteImagesInfo writeImagesInfo, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, writeImagesInfo, z) == null) {
            this.h = writeImagesInfo;
            Context context = getContext();
            ea5 ea5Var = this.i;
            b bVar = this.r;
            if (this.o == 10) {
                z2 = true;
            } else {
                z2 = false;
            }
            c cVar = new c(context, ea5Var, this, bVar, z2);
            this.j = cVar;
            cVar.d(this.h);
            this.e.setAdapter(this.j, z);
            int maxItemNum = this.e.getMaxItemNum();
            int size = writeImagesInfo.size();
            if (size == 1 && !TextUtils.isEmpty(this.m)) {
                this.f.setText(this.m);
            } else if (!s && size > 1) {
                this.f.setText(R.string.editor_mutiiamge_drag_tip);
                s = true;
                TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
            } else {
                this.f.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            }
            if (size > 0) {
                String str = size + "";
            }
        }
    }
}
