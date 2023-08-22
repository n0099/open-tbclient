package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.lfa;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class e2b extends s1b<e3b> implements m2b, n2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RichTextEditor t;
    @Nullable
    public l2b u;
    @NonNull
    public final a4b v;
    public final RichImageItem.f w;

    @Override // com.baidu.tieba.q2b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements RichImageItem.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2b a;

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) {
            }
        }

        public a(e2b e2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2bVar;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, imageFileInfo, view2) != null) || this.a.b == null) {
                return;
            }
            if (ListUtils.isEmpty(this.a.v.g().getChosedFiles())) {
                this.a.b.j();
            }
            this.a.b.x(new int[]{10, 34});
        }
    }

    /* loaded from: classes5.dex */
    public class b implements RichTextEditor.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2b a;

        public b(e2b e2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2bVar;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichTextEditor.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.showToast(R.string.over_limit_tip);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2b(TbPageContext<?> tbPageContext, @NonNull a4b a4bVar, @NonNull e1b e1bVar, @NonNull w3b w3bVar) {
        super(tbPageContext, e3b.class, e1bVar, w3bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, a4bVar, e1bVar, w3bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (e1b) objArr2[2], (w3b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.v = a4bVar;
        a4bVar.c(this);
    }

    @Override // com.baidu.tieba.s1b
    public void H(Editable editable) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.H(editable);
            WriteData writeData = this.e;
            if (writeData != null && (richTextEditor = this.t) != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.s1b
    public void K(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.i(arrayList);
    }

    @Override // com.baidu.tieba.s1b
    public void L(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, arrayList) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.m(arrayList);
    }

    public void W(l2b l2bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, l2bVar) == null) {
            this.u = l2bVar;
        }
    }

    public final void X(ImageFileInfo imageFileInfo) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, imageFileInfo) == null) && (richTextEditor = this.t) != null && this.e != null) {
            richTextEditor.u(imageFileInfo);
            this.e.setRichContentData(this.t.getPlainTextContentData());
        }
    }

    public void Y(lfa.f fVar) {
        t3b t3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) && (t3bVar = this.l) != null) {
            t3bVar.p(fVar);
        }
    }

    @Override // com.baidu.tieba.p2b
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) {
            writeData.setRichTextEditorMode(true);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.q2b
    public void e(boolean z) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && !z && (richTextEditor = this.t) != null && richTextEditor.getLastFocusEdit() != null) {
            this.t.getLastFocusEdit().clearFocus();
        }
    }

    @Override // com.baidu.tieba.n2b
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.n2b
    public void k(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            Z(str);
        }
    }

    @Override // com.baidu.tieba.s1b, com.baidu.tieba.p2b
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            super.onChangeSkinType(i);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.x();
            }
        }
    }

    @Override // com.baidu.tieba.s1b, com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v.o(bundle);
        }
    }

    @Override // com.baidu.tieba.m2b
    public void onUpdate(Object obj) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, obj) == null) && (obj instanceof SelectForumData) && (richTextEditor = this.t) != null) {
            richTextEditor.setForumId(JavaTypesHelper.toLong(((SelectForumData) obj).forumId, 0L));
        }
    }

    @Override // com.baidu.tieba.n2b
    public void u(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            a0(str);
        }
    }

    @Override // com.baidu.tieba.n2b
    public void v(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            a0(str);
        }
    }

    @Override // com.baidu.tieba.s1b
    public void J(uc5 uc5Var) {
        RichTextEditor richTextEditor;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uc5Var) == null) && this.b != null && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0 && (b2 = this.v.b(this.b, uc5Var)) != null) {
            X(b2);
            this.b.j();
            this.b.x(new int[]{10, 34});
        }
    }

    @Override // com.baidu.tieba.p2b
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) {
            this.v.d(writeData);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                this.t.setWriteImagesInfo(this.v.g());
                writeData.setRichContentData(this.t.getPostServerContentData());
                writeData.setServerRichContent(this.t.getPostServerContentData());
                writeData.setRichTextEditorMode(true);
            }
        }
    }

    @Override // com.baidu.tieba.s1b
    @Nullable
    public ArrayList<AtSelectData> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                return this.t.getAtDataInText();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    @Nullable
    public EditText O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                return this.t.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.b();
            this.v.q(this);
        }
    }

    @Override // com.baidu.tieba.q2b
    public void l() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (richTextEditor = this.t) != null && richTextEditor.getLastFocusEdit() != null) {
            this.t.getLastFocusEdit().requestFocus();
        }
    }

    @Override // com.baidu.tieba.q2b
    public void n() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        this.n.f(richTextEditor.getLastFocusEdit(), false);
    }

    @Override // com.baidu.tieba.q2b
    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                return richTextEditor.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && !richTextEditor.v()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && str != null && this.b != null && this.t != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(str);
            writeImagesInfo.updateQuality();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
                int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
                this.v.g().getChosedFiles().remove(originalImgIndex);
                this.v.g().getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.t.q(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                this.b.x(new int[]{10, 34});
            }
        }
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && str != null && this.b != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(str);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.v.g().addChooseFile(imageFileInfo);
                    X(imageFileInfo);
                }
            }
            this.b.x(new int[]{10, 34});
            this.b.j();
        }
    }

    @Override // com.baidu.tieba.p2b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, writeData) == null) && writeData.getWriteImagesInfo() != null) {
            this.v.r(writeData.getWriteImagesInfo());
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.setWriteImagesInfo(writeData.getWriteImagesInfo());
                this.t.t(writeData.getRichContentData());
            }
            WriteData writeData2 = this.e;
            if (writeData2 != null) {
                writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
                this.e.setRichContentData(writeData.getRichContentData());
            }
        }
    }

    @Override // com.baidu.tieba.s1b, com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void j(@NonNull r2b r2bVar) {
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, r2bVar) == null) {
            super.j(r2bVar);
            l2b l2bVar = this.u;
            if (l2bVar != null) {
                l2bVar.l(this);
            }
            WriteImagesInfo g = this.v.g();
            if (g.size() > 0 && (chosedFiles = g.getChosedFiles()) != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    if (imageFileInfo != null) {
                        X(imageFileInfo);
                    }
                }
                r2b r2bVar2 = this.b;
                if (r2bVar2 != null) {
                    r2bVar2.j();
                    this.b.x(new int[]{10, 34});
                }
            }
        }
    }

    @Override // com.baidu.tieba.s1b, com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.v.h(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.s1b, com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.v.m(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.p2b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0554, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091d16);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f09015e);
            RichTextEditor richTextEditor = (RichTextEditor) this.c.findViewById(R.id.obfuscated_res_0x7f091f29);
            this.t = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.v.g());
            this.t.setOutImageOperateListener(this.w);
            this.t.setOnSpanGroupChangedListener(this.p);
            this.t.setEditOnClickListener(this.o);
            this.t.setEditOnFocusChangeListener(this.s);
            this.t.setBigEmotionSpanHandler(this.q);
            this.t.l(this.r);
            this.t.setRichTextLengthListener(new b(this));
            WriteData writeData = this.e;
            if (writeData != null) {
                this.t.setForumId(JavaTypesHelper.toLong(writeData.getForumId(), 0L));
            }
            this.t.o();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
