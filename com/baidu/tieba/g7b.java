package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g7b implements n7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t6b a;
    public int b;
    public int c;
    public boolean d;

    public g7b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
    }

    @Override // com.baidu.tieba.n7b
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            t6b t6bVar = this.a;
            if (t6bVar == null || bArr == null) {
                return 0;
            }
            this.b += bArr.length;
            t6bVar.putBytes(bArr, i);
            return this.b;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.n7b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.d && this.a.available() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n7b
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (t6b) vab.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            t6b t6bVar = this.a;
            if (t6bVar != null) {
                t6bVar.initVoiceChanger(i, i2, i3, i4);
            }
            return this.a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.n7b
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            t6b t6bVar = this.a;
            if (t6bVar == null || t6bVar.availableBytes() <= 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[4096];
            int bytes = this.a.getBytes(bArr, 4096);
            this.c += bytes;
            if (bytes == 0) {
                return null;
            }
            if (4096 == bytes) {
                return bArr;
            }
            byte[] bArr2 = new byte[bytes];
            System.arraycopy(bArr, 0, bArr2, 0, bytes);
            return bArr2;
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(int[] iArr) {
        t6b t6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (t6bVar = this.a) == null) {
            return;
        }
        t6bVar.setVoiceChangeType(iArr);
    }

    @Override // com.baidu.tieba.n7b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n7b
    public void c() {
        t6b t6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (t6bVar = this.a) == null) {
            return;
        }
        t6bVar.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        t6b t6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (t6bVar = this.a) == null) {
            return;
        }
        t6bVar.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // com.baidu.tieba.n7b
    public void d() {
        t6b t6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t6bVar = this.a) == null) {
            return;
        }
        t6bVar.close();
        this.a = null;
    }

    @Override // com.baidu.tieba.n7b
    public void e() {
        t6b t6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t6bVar = this.a) == null) {
            return;
        }
        t6bVar.clearQueues();
    }
}
