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
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f05;
import com.repackage.g35;
import com.repackage.li;
import com.repackage.n05;
import com.repackage.rb;
import com.repackage.sz4;
import com.repackage.t25;
import com.repackage.um;
import com.repackage.x25;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgToolView extends DragContainer implements f05, DragHorizonScrollView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean s;
    public transient /* synthetic */ FieldHolder $fh;
    public DragHorizonScrollView e;
    public TextView f;
    public DragLayer g;
    public WriteImagesInfo h;
    public x25 i;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e.r()) {
                return;
            }
            this.a.delete(view2);
            int delete = this.a.e.delete(view2);
            if (delete < 0 || delete >= this.a.h.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.h.getChosedFiles().remove(delete);
            if (remove.isTempFile()) {
                rb.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            int maxItemNum = this.a.e.getMaxItemNum();
            int size = this.a.h.size();
            this.a.f.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0534, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            int size2 = this.a.h.getChosedFiles().size();
            if (this.a.k != null) {
                this.a.k.A(new sz4(this.a.n, -1, null));
                if (size2 > 0) {
                    this.a.k.A(new sz4(2, this.a.o, String.valueOf(size2)));
                } else {
                    this.a.k.A(new sz4(2, this.a.o, null));
                }
                if (maxItemNum == 1 && size2 == 0) {
                    if (this.a.p) {
                        this.a.k.A(new sz4(1, 2, null));
                        return;
                    }
                    MultiImgToolView multiImgToolView = this.a;
                    multiImgToolView.p(multiImgToolView.h, true);
                    this.a.f.setText(this.a.q);
                    this.a.k.invalidate();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2);
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WriteImagesInfo a;
        public Context b;
        public x25 c;
        public f05 d;
        public b e;
        public boolean f;

        /* loaded from: classes3.dex */
        public class a implements t25 {
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

            @Override // com.repackage.t25
            public void a(um umVar, String str, boolean z) {
                TbImageView tbImageView;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, umVar, str, z) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(str)) == null || umVar == null) {
                    return;
                }
                tbImageView.invalidate();
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (indexOfChild = this.a.indexOfChild(view2)) < 0) {
                    return;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.b.getItem(indexOfChild);
                if (!(imageFileInfo != null && new File(imageFileInfo.getFilePath()).exists())) {
                    li.K(this.b.b, R.string.obfuscated_res_0x7f0f0533);
                } else if (this.b.d != null) {
                    this.b.d.g(new sz4(15, 0, Integer.valueOf(indexOfChild)));
                }
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.imagetool.MultiImgToolView$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0171c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrameLayout a;
            public final /* synthetic */ c b;

            public View$OnClickListenerC0171c(c cVar, FrameLayout frameLayout) {
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.e == null) {
                    return;
                }
                this.b.e.a(this.a);
            }
        }

        public c(Context context, x25 x25Var, f05 f05Var, b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, x25Var, f05Var, bVar, Boolean.valueOf(z)};
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
            this.c = x25Var;
            this.d = f05Var;
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
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.a.getChosedFiles().get(i) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = (FrameLayout) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0246, (ViewGroup) null);
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.a.getChosedFiles(), i);
                if (imageFileInfo == null) {
                    return null;
                }
                int measuredWidth = (viewGroup.getMeasuredWidth() - (this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702f1) * 2)) + this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
                FrameLayout frameLayout = (FrameLayout) view2;
                LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.obfuscated_res_0x7f090f92);
                FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.obfuscated_res_0x7f091c98);
                TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f090f83);
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(imageFileInfo.isLong());
                if (measuredWidth > 0) {
                    int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                    int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                    SkinManager.setBackgroundResource(frameLayout2, R.drawable.bg_add_photo);
                    frameLayout2.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(g35.g(paddingRight, measuredHeight));
                    tbImageView.setTag(imageFileInfo.toCachedKey(true));
                    if (this.c.d(imageFileInfo, new a(this, viewGroup), true) != null) {
                        tbImageView.invalidate();
                    }
                }
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
                if (this.f) {
                    frameLayout.setOnClickListener(new b(this, viewGroup));
                }
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f090757);
                SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_close);
                imageView.setOnClickListener(new View$OnClickListenerC0171c(this, frameLayout));
                frameLayout.setContentDescription(frameLayout.getResources().getString(R.string.obfuscated_res_0x7f0f052f) + (i + 1) + " " + imageFileInfo.getModifyTime());
                return frameLayout;
            }
            return (View) invokeILL.objValue;
        }
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

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.c
    public void a(int i, int i2) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i == i2 || (writeImagesInfo = this.h) == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = this.h.getChosedFiles();
        chosedFiles.add(i2, chosedFiles.remove(i));
    }

    @Override // com.repackage.f05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.repackage.f05
    public void g(sz4 sz4Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sz4Var) == null) || (editorTools = this.k) == null) {
            return;
        }
        editorTools.A(sz4Var);
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (DragHorizonScrollView) invokeV.objValue;
    }

    public DragLayer getDragLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (DragLayer) invokeV.objValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h.getChosedFiles().size() : invokeV.intValue;
    }

    public TextView getMutiImageTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    @Override // com.repackage.f05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.repackage.f05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.f05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = (DragHorizonScrollView) findViewById(R.id.obfuscated_res_0x7f091466);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091463);
            this.g = (DragLayer) findViewById(R.id.obfuscated_res_0x7f091465);
        }
    }

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sz4Var) == null) || sz4Var == null) {
            return;
        }
        int i = sz4Var.a;
        if (i == 9) {
            c cVar = this.j;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
            g(new sz4(2, this.o, null));
        } else if (i == 12 && (obj = sz4Var.c) != null && (obj instanceof n05)) {
            p(((n05) obj).a, ((n05) obj).b);
        }
    }

    @Override // com.repackage.f05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.common_color_10255);
        }
    }

    public final void p(WriteImagesInfo writeImagesInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, writeImagesInfo, z) == null) {
            this.h = writeImagesInfo;
            c cVar = new c(getContext(), this.i, this, this.r, this.o == 10);
            this.j = cVar;
            cVar.d(this.h);
            this.e.setAdapter(this.j, z);
            int maxItemNum = this.e.getMaxItemNum();
            int size = writeImagesInfo.size();
            if (size == 1 && !TextUtils.isEmpty(this.m)) {
                this.f.setText(this.m);
            } else if (!s && size > 1) {
                this.f.setText(R.string.obfuscated_res_0x7f0f0532);
                s = true;
                TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
            } else {
                this.f.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0534, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            }
            if (size > 0) {
                String str = size + "";
            }
        }
    }

    public void setAsyncLocalImageLoader(x25 x25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, x25Var) == null) {
            this.i = x25Var;
        }
    }

    public void setDefaultTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.m = str;
        }
    }

    public void setDeleteAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.repackage.f05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.k = editorTools;
        }
    }

    public void setNeedQuit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.p = z;
        }
    }

    public void setNoPicTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (StringUtils.isNULL(str)) {
                this.q = " ";
            } else {
                this.q = str;
            }
        }
    }

    public void setTargetToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.repackage.f05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.l = i;
        }
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
}
